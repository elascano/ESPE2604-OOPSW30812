import { MazeController } from '../controller/MazeController.js';

const controller = new MazeController();

const txtRows = document.getElementById('txtRows');
const txtColumns = document.getElementById('txtColumns');
const btnGenerate = document.getElementById('btnGenerate');
const errorMsg = document.getElementById('errorMsg');
const emptyState = document.getElementById('emptyState');

const canvas = document.getElementById('mazeCanvas');
const ctx = canvas.getContext('2d');
const asciiEl = document.getElementById('mazeAscii');

const btnViewCanvas = document.getElementById('btnViewCanvas');
const btnViewAscii = document.getElementById('btnViewAscii');

let currentView = 'canvas';

function showError(message) {
  errorMsg.textContent = message;
  errorMsg.hidden = false;
}

function clearError() {
  errorMsg.hidden = true;
  errorMsg.textContent = '';
}

function setView(view) {
  currentView = view;
  const isCanvas = view === 'canvas';
  canvas.hidden = !isCanvas;
  asciiEl.hidden = isCanvas;
  btnViewCanvas.classList.toggle('is-active', isCanvas);
  btnViewAscii.classList.toggle('is-active', !isCanvas);
}

btnViewCanvas.addEventListener('click', () => setView('canvas'));
btnViewAscii.addEventListener('click', () => setView('ascii'));

function drawMazeOnCanvas(maze) {
  const rows = maze.getRows();
  const columns = maze.getColumns();

  const cell = Math.max(14, Math.min(40, Math.floor(560 / Math.max(rows, columns))));
  const margin = 18;
  const width = columns * cell + margin * 2;
  const height = rows * cell + margin * 2;

  const dpr = window.devicePixelRatio || 1;
  canvas.width = width * dpr;
  canvas.height = height * dpr;
  canvas.style.width = `${width}px`;
  canvas.style.height = `${height}px`;
  ctx.setTransform(dpr, 0, 0, dpr, 0, 0);

  ctx.clearRect(0, 0, width, height);

  const lineColor = getComputedStyle(document.documentElement).getPropertyValue('--line').trim() || '#6FB7E0';
  const amber = getComputedStyle(document.documentElement).getPropertyValue('--amber').trim() || '#F2A65A';
  const coral = getComputedStyle(document.documentElement).getPropertyValue('--coral').trim() || '#E8735A';

  ctx.strokeStyle = lineColor;
  ctx.lineCap = 'square';
  ctx.lineWidth = 2;

  ctx.beginPath();
  for (let r = 0; r < rows; r++) {
    for (let c = 0; c < columns; c++) {
      const room = maze.getRoom(r, c);
      const wall = room.getWalls()[0];
      if (!wall) continue;

      const x0 = margin + c * cell;
      const y0 = margin + r * cell;
      const x1 = x0 + cell;
      const y1 = y0 + cell;

      if (wall.isNorthWall()) { ctx.moveTo(x0, y0); ctx.lineTo(x1, y0); }
      if (wall.isSouthWall()) { ctx.moveTo(x0, y1); ctx.lineTo(x1, y1); }
      if (wall.isWestWall()) { ctx.moveTo(x0, y0); ctx.lineTo(x0, y1); }
      if (wall.isEastWall()) { ctx.moveTo(x1, y0); ctx.lineTo(x1, y1); }
    }
  }
  ctx.stroke();

  const markerRadius = Math.max(3, cell * 0.16);

  ctx.fillStyle = amber;
  ctx.beginPath();
  ctx.arc(margin + cell / 2, margin + cell / 2, markerRadius, 0, Math.PI * 2);
  ctx.fill();

  ctx.fillStyle = coral;
  ctx.beginPath();
  ctx.arc(
    margin + (columns - 0.5) * cell,
    margin + (rows - 0.5) * cell,
    markerRadius,
    0,
    Math.PI * 2,
  );
  ctx.fill();
}

function generateMaze() {
  clearError();

  const rows = parseInt(txtRows.value, 10);
  const columns = parseInt(txtColumns.value, 10);

  if (Number.isNaN(rows) || Number.isNaN(columns) || !Number.isInteger(rows) || !Number.isInteger(columns)) {
    showError('Ingrese únicamente números.');
    return;
  }

  if (rows <= 0 || columns <= 0) {
    showError('Rows y Columns deben ser mayores que cero.');
    return;
  }

  controller.createMaze(rows, columns);

  emptyState.hidden = true;
  drawMazeOnCanvas(controller.getMaze());
  asciiEl.textContent = controller.drawMaze();
}

btnGenerate.addEventListener('click', generateMaze);

txtRows.addEventListener('keydown', (e) => { if (e.key === 'Enter') generateMaze(); });
txtColumns.addEventListener('keydown', (e) => { if (e.key === 'Enter') generateMaze(); });
