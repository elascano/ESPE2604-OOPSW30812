'use client';

import { useState, useEffect } from 'react';
import { createDemoCharacter, interactItem, attackDummy, CharacterDTO, saveGameAction, getAllCharactersAction, loadCharacter } from '../server/actions';

export default function CharacterDashboard() {
  const [character, setCharacter] = useState<CharacterDTO | null>(null);
  const [log, setLog] = useState<string[]>(['Bienvenido al sistema RPG...']);
  const [isLoading, setIsLoading] = useState(false);
  const [savedGames, setSavedGames] = useState<{id: string, name: string, type: string, level: number}[]>([]);
  const [selectedGameId, setSelectedGameId] = useState<string>('');

  useEffect(() => {
    fetchSavedGames();
  }, []);

  const fetchSavedGames = async () => {
    const games = await getAllCharactersAction();
    setSavedGames(games);
    if (games.length > 0) {
      setSelectedGameId(games[0].id);
    }
  };

  const addLog = (msg: string) => {
    if (msg) setLog(prev => [msg, ...prev].slice(0, 50));
  };

  const handleCreateDemo = async () => {
    setIsLoading(true);
    const { msg, character } = await createDemoCharacter();
    addLog(msg);
    setCharacter(character);
    await fetchSavedGames();
    setIsLoading(false);
  };

  const handleSaveGame = async () => {
    setIsLoading(true);
    const { msg } = await saveGameAction();
    addLog(msg);
    await fetchSavedGames();
    setIsLoading(false);
  };

  const handleLoadGame = async () => {
    if (!selectedGameId) return;
    setIsLoading(true);
    const { msg, character } = await loadCharacter(selectedGameId);
    addLog(msg);
    setCharacter(character);
    setIsLoading(false);
  };

  const handleInteract = async (itemId: string) => {
    setIsLoading(true);
    const { msg, character } = await interactItem(itemId);
    addLog(msg);
    setCharacter(character);
    setIsLoading(false);
  };

  const handleAttack = async () => {
    setIsLoading(true);
    const { msg, character } = await attackDummy();
    addLog(msg);
    setCharacter(character);
    setIsLoading(false);
  };

  const handleDragStart = (e: React.DragEvent, itemId: string) => {
    e.dataTransfer.setData('text/plain', itemId);
  };

  const handleDrop = async (e: React.DragEvent) => {
    e.preventDefault();
    const itemId = e.dataTransfer.getData('text/plain');
    if (itemId) {
      await handleInteract(itemId);
    }
  };

  const handleDragOver = (e: React.DragEvent) => {
    e.preventDefault();
  };

  const getImageForItem = (item: any) => {
    if (item.classType === 'Weapon') return '/images/weapon.png';
    if (item.classType === 'Potion') return '/images/potion.png';
    if (item.classType === 'Armor') {
      const s = item.slot?.toLowerCase() || '';
      if (s.includes('helmet')) return '/images/helmet.png';
      if (s.includes('chest')) return '/images/chest.png';
      if (s.includes('legs')) return '/images/legs.png';
      if (s.includes('boots')) return '/images/boots.png';
      return '/images/chest.png';
    }
    if (item.classType === 'Artifact') {
      const s = item.slot?.toLowerCase() || '';
      if (s.includes('ring')) return '/images/ring.png';
      if (s.includes('amulet')) return '/images/amulet.png';
      return '/images/amulet.png';
    }
    return null;
  };

  if (!character) {
    return (
      <div className="min-h-screen bg-[#1e1e2e] text-[#cdd6f4] p-5 font-sans flex items-center justify-center">
        <div className="text-center bg-[#181825] p-10 rounded-2xl border border-[#313244] shadow-2xl max-w-md w-full">
          <h1 className="text-4xl font-bold mb-8 text-[#cba6f7]">ESPE RPG System</h1>
          <button 
            onClick={handleCreateDemo}
            disabled={isLoading}
            className="w-full mb-4 px-6 py-3 bg-[#cba6f7] text-[#11111b] font-bold rounded hover:bg-[#b4befe] transition-colors disabled:opacity-50"
          >
            {isLoading ? 'Cargando...' : 'Iniciar Nueva Partida Demo'}
          </button>
          
          {savedGames.length > 0 && (
            <div className="mt-8 pt-6 border-t border-[#313244]">
              <h2 className="text-[#a6adc8] mb-3 font-semibold">O cargar partida existente:</h2>
              <select 
                className="w-full bg-[#11111b] border border-[#45475a] text-[#cdd6f4] rounded p-2 mb-3"
                value={selectedGameId}
                onChange={(e) => setSelectedGameId(e.target.value)}
              >
                {savedGames.map(g => (
                  <option key={g.id} value={g.id}>{g.name} ({g.type} Lv.{g.level})</option>
                ))}
              </select>
              <button 
                onClick={handleLoadGame}
                disabled={isLoading || !selectedGameId}
                className="w-full px-6 py-3 bg-[#89b4fa] text-[#11111b] font-bold rounded hover:bg-[#74c7ec] transition-colors disabled:opacity-50"
              >
                {isLoading ? 'Cargando...' : 'Cargar Partida'}
              </button>
            </div>
          )}
        </div>
      </div>
    );
  }

  const hpPercent = (character.hp / character.maxHp) * 100;
  let hpColor = '#a6e3a1'; // Green
  if (hpPercent <= 50) hpColor = '#f9e2af'; // Yellow
  if (hpPercent <= 20) hpColor = '#f38ba8'; // Red

  return (
    <div className="min-h-screen bg-[#1e1e2e] text-[#cdd6f4] p-5 font-sans">
      <div className="max-w-[1000px] mx-auto">
        <div className="mb-5 border-b border-[#313244] pb-4">
          <h1 className="text-2xl font-bold text-[#cba6f7]">ESPE RPG System</h1>
        </div>

        <div className="flex gap-5">
          {/* LEFT COLUMN: Control Panel & Console */}
          <div className="w-[280px] flex flex-col gap-4 shrink-0">
            {/* Control Panel */}
            <div className="bg-[#181825] p-5 rounded-xl border border-[#313244]">
              <h2 className="text-[#89b4fa] font-bold mb-4 uppercase text-sm tracking-wide">Panel de Control</h2>
              <div className="space-y-3">
                <button 
                  onClick={handleCreateDemo}
                  disabled={isLoading}
                  className="w-full py-2 bg-[#89b4fa] text-[#11111b] font-bold rounded text-sm hover:bg-[#74c7ec] disabled:opacity-50"
                >
                  Nueva Partida Demo
                </button>
                <button 
                  onClick={handleSaveGame}
                  disabled={isLoading}
                  className="w-full py-2 bg-[#a6e3a1] text-[#11111b] font-bold rounded text-sm hover:bg-[#94e2d5] disabled:opacity-50"
                >
                  Guardar Partida
                </button>
                
                <div className="pt-3 border-t border-[#313244]">
                  <select 
                    className="w-full bg-[#11111b] border border-[#45475a] text-xs text-[#cdd6f4] rounded p-2 mb-2"
                    value={selectedGameId}
                    onChange={(e) => setSelectedGameId(e.target.value)}
                  >
                    {savedGames.length === 0 && <option value="">Sin partidas</option>}
                    {savedGames.map(g => (
                      <option key={g.id} value={g.id}>{g.name} ({g.type})</option>
                    ))}
                  </select>
                  <button 
                    onClick={handleLoadGame}
                    disabled={isLoading || !selectedGameId}
                    className="w-full py-2 bg-[#f9e2af] text-[#11111b] font-bold rounded text-sm hover:bg-[#f2cdcd] disabled:opacity-50"
                  >
                    Cargar Partida
                  </button>
                </div>
              </div>
            </div>

            {/* Console Card */}
            <div className="bg-[#181825] p-5 rounded-xl border border-[#313244] flex-1 flex flex-col min-h-[300px]">
              <h2 className="text-[#89b4fa] font-bold mb-4 uppercase text-sm tracking-wide">Registro de Eventos</h2>
              <div className="flex-1 bg-[#11111b] p-3 rounded overflow-y-auto text-xs font-mono text-[#a6adc8] border border-[#313244]">
                {log.map((entry, i) => (
                  <div key={i} className="mb-1">{`> ${entry}`}</div>
                ))}
              </div>
            </div>
          </div>

          {/* CENTER COLUMN: Player Stats & Combat */}
          <div className="w-[400px] flex flex-col gap-5 shrink-0">
            {/* Player Stats */}
            <div className="bg-[#181825] p-5 rounded-xl border border-[#313244]">
              <div className="flex gap-4 items-center mb-5">
                <div 
                  className="w-16 h-16 bg-[#313244] rounded-full border-2 border-[#cba6f7] flex items-center justify-center overflow-hidden"
                  onDrop={handleDrop}
                  onDragOver={handleDragOver}
                  title="Arrastra un objeto aquí para usar/equipar"
                >
                  <img 
                    src={character.type === 'Guerrero' ? '/images/warrior.png' : '/images/mage.png'} 
                    alt={character.type} 
                    className="w-full h-full object-cover"
                    onError={(e) => { e.currentTarget.style.display = 'none'; e.currentTarget.parentElement!.innerHTML = character.type === 'Guerrero' ? '🛡️' : '🔮'; }}
                  />
                </div>
                <div>
                  <div className="text-xl font-bold text-white">{character.name}</div>
                  <div className="text-sm text-[#a6adc8]">{character.type} | EXP: {character.exp}/100</div>
                </div>
              </div>

              {/* HP Bar */}
              <div className="mb-5">
                <div className="text-sm text-[#a6adc8] mb-1 font-bold">Salud (HP)</div>
                <div className="h-4 bg-[#313244] rounded-full overflow-hidden relative">
                  <div 
                    className="h-full transition-all" 
                    style={{ width: `${hpPercent}%`, backgroundColor: hpColor }}
                  ></div>
                </div>
                <div className="text-xs text-right mt-1 text-[#bac2de]">{character.hp.toFixed(0)} / {character.maxHp.toFixed(0)}</div>
              </div>

              {/* Attributes */}
              <div className="flex justify-between mb-5 border-b border-[#313244] pb-4">
                <div className="w-1/2">
                  <div className="text-xs text-[#a6adc8] font-bold">Atributo Primario</div>
                  <div className="text-[#cba6f7] font-mono">{character.primaryStatStr}</div>
                </div>
                <div className="w-1/2">
                  <div className="text-xs text-[#a6adc8] font-bold">Recurso Especial</div>
                  <div className="text-[#89b4fa] font-mono">{character.secondaryStatStr}</div>
                </div>
              </div>

              <div className="flex justify-between mb-5">
                <div className="w-1/2">
                  <div className="text-xs text-[#a6adc8] font-bold">Bonus Daño</div>
                  <div className="text-white">+{character.bonusDamage.toFixed(1)}</div>
                </div>
                <div className="w-1/2">
                  <div className="text-xs text-[#a6adc8] font-bold">Defensa</div>
                  <div className="text-white">+{character.bonusDefense.toFixed(1)}</div>
                </div>
              </div>

              {/* Active Equipment */}
              <div>
                <h3 className="text-sm font-bold text-white mb-3">Equipamiento Activo</h3>
                <div className="grid grid-cols-3 gap-2">
                  {Object.entries(character.equipped).map(([slot, itemName]) => {
                    // Determinar qué imagen mostrar si está equipado
                    let imgPath = null;
                    if (itemName) {
                      const s = slot.toLowerCase();
                      if (s.includes('helmet')) imgPath = '/images/helmet.png';
                      else if (s.includes('chest')) imgPath = '/images/chest.png';
                      else if (s.includes('legs')) imgPath = '/images/legs.png';
                      else if (s.includes('boots')) imgPath = '/images/boots.png';
                      else if (s.includes('ring')) imgPath = '/images/ring.png';
                      else if (s.includes('amulet')) imgPath = '/images/amulet.png';
                      // If it's a weapon, maybe we have a slot called 'weapon', but it wasn't rendered as a distinct slot in equipped... 
                      // Wait, weapons are equipped but the slot is not strictly defined in CharacterDTO right now, they give bonus damage directly.
                    }

                    return (
                      <div 
                        key={slot} 
                        className={`h-[75px] w-full rounded flex flex-col items-center justify-center p-1 text-center cursor-pointer transition-colors relative overflow-hidden ${itemName ? 'bg-[#45475a] border border-[#cba6f7]' : 'bg-[#313244]'}`}
                        onDrop={handleDrop}
                        onDragOver={handleDragOver}
                        title={itemName ? `${itemName} (Equipado)` : `Arrastra aquí para equipar en ${slot}`}
                      >
                        {imgPath && itemName && (
                           <img src={imgPath} className="absolute inset-0 w-full h-full object-contain opacity-20 pointer-events-none" alt={slot} />
                        )}
                        <div className="text-[10px] text-[#bac2de] uppercase z-10">{slot}</div>
                        <div className="text-[10px] text-white font-bold break-words z-10 line-clamp-2">{itemName || '-'}</div>
                      </div>
                    );
                  })}
                </div>
              </div>
            </div>

            {/* Combat */}
            <div className="bg-[#181825] p-5 rounded-xl border border-[#313244]">
              <h2 className="text-[#f38ba8] font-bold mb-4 uppercase text-sm tracking-wide">Zona de Combate</h2>
              <div className="flex gap-4 items-center mb-4 p-3 bg-[#313244] rounded">
                <div className="w-12 h-12 bg-[#181825] rounded border border-[#f38ba8] overflow-hidden">
                  <img src="/images/enemy.png" alt="Enemy" className="w-full h-full object-cover" onError={(e) => { e.currentTarget.style.display = 'none'; e.currentTarget.parentElement!.innerHTML = '👹'; }} />
                </div>
                <div>
                  <div className="text-white font-bold">Enemigo Feroz</div>
                  <div className="text-xs text-[#a6adc8]">Nivel Desconocido</div>
                </div>
              </div>
              <button 
                onClick={handleAttack}
                disabled={isLoading}
                className="w-full py-2 bg-[#f38ba8] text-[#11111b] font-bold rounded hover:bg-[#eba0ac] disabled:opacity-50"
              >
                Atacar Enemigo
              </button>
            </div>
          </div>

          {/* RIGHT COLUMN: Inventory */}
          <div className="w-[280px] flex flex-col shrink-0">
            <div className="bg-[#181825] p-5 rounded-xl border border-[#313244] flex-1">
              <h2 className="text-[#a6e3a1] font-bold mb-2 uppercase text-sm tracking-wide">Inventario</h2>
              <p className="text-xs text-[#6c7086] mb-4">Arrastra los items para usarlos/equiparlos</p>
              
              <div className="flex flex-col gap-2">
                {character.inventory.map((item, idx) => {
                  const imgSrc = getImageForItem(item);
                  return (
                    <div 
                      key={`${item.id}-${idx}`}
                      draggable
                      onDragStart={(e) => handleDragStart(e, item.id)}
                      className="bg-[#313244] p-3 rounded cursor-grab border border-[#45475a] hover:border-[#a6e3a1] flex gap-3 items-center"
                    >
                      {imgSrc && (
                        <div className="w-10 h-10 bg-[#181825] rounded p-1 shrink-0">
                          <img src={imgSrc} alt={item.name} className="w-full h-full object-contain" />
                        </div>
                      )}
                      <div className="min-w-0 flex-1">
                        <div className="text-sm font-bold text-white truncate">{item.name}</div>
                        <div className="text-[10px] text-[#bac2de] truncate">{item.desc}</div>
                        <div className="text-[10px] text-[#a6e3a1] mt-1 italic uppercase tracking-wider">{item.classType}</div>
                      </div>
                    </div>
                  );
                })}
                {character.inventory.length === 0 && (
                  <div className="text-xs text-[#6c7086] text-center p-4">Vacío</div>
                )}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
