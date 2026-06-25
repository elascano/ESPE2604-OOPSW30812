'use client';

import { useState, useEffect } from 'react';
import { 
  createDemoCharacter, 
  createCharacterAction,
  restCharacterAction,
  lootRandomItemAction,
  unequipItemAction,
  interactItem, 
  attackDummy, 
  CharacterDTO, 
  saveGameAction, 
  getAllCharactersAction, 
  loadCharacter 
} from '../server/actions';

export default function CharacterDashboard() {
  const [character, setCharacter] = useState<CharacterDTO | null>(null);
  const [log, setLog] = useState<string[]>(['Bienvenido al sistema RPG...']);
  const [isLoading, setIsLoading] = useState(false);
  const [savedGames, setSavedGames] = useState<{id: string, name: string, type: string, level: number}[]>([]);
  const [selectedGameId, setSelectedGameId] = useState<string>('');
  
  // Custom Character Creation State
  const [newName, setNewName] = useState('');
  const [newClass, setNewClass] = useState('Warrior');

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

  const handleCreateCustom = async () => {
    if (!newName.trim()) return;
    setIsLoading(true);
    const { msg, character } = await createCharacterAction(newName.trim(), newClass);
    addLog(msg);
    if (character) setCharacter(character);
    await fetchSavedGames();
    setNewName('');
    setIsLoading(false);
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

  const handleRest = async () => {
    setIsLoading(true);
    const { msg, character } = await restCharacterAction();
    addLog(msg);
    if (character) setCharacter(character);
    setIsLoading(false);
  };

  const handleLoot = async () => {
    setIsLoading(true);
    const { msg, character } = await lootRandomItemAction();
    addLog(msg);
    if (character) setCharacter(character);
    setIsLoading(false);
  };

  const handleUnequip = async (slot: string) => {
    setIsLoading(true);
    const { msg, character } = await unequipItemAction(slot);
    addLog(msg);
    if (character) setCharacter(character);
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

  // Helper to color log messages
  const getLogColorClass = (msg: string) => {
    if (msg.includes('❌') || msg.includes('Game Over') || msg.includes('error') || msg.includes('Error')) {
      return 'text-[#f38ba8] font-bold';
    }
    if (msg.includes('⭐') || msg.includes('SUBISTE DE NIVEL') || msg.includes('restaurado') || msg.includes('guardada') || msg.includes('exitosamente')) {
      return 'text-[#a6e3a1] font-bold';
    }
    if (msg.includes('⚔️') || msg.includes('atacó') || msg.includes('contraatacó') || msg.includes('daño')) {
      return 'text-[#f9e2af]';
    }
    if (msg.includes('botín') || msg.includes('encontrado') || msg.includes('equipado') || msg.includes('mochila') || msg.includes('quitado')) {
      return 'text-[#cba6f7]';
    }
    return 'text-[#bac2de]';
  };

  // Render selection dashboard when no character is active
  if (!character) {
    return (
      <div className="min-h-screen bg-[#1e1e2e] text-[#cdd6f4] p-5 font-sans flex items-center justify-center">
        <div className="text-center bg-[#181825] p-10 rounded-2xl border border-[#313244] shadow-2xl max-w-md w-full flex flex-col gap-6">
          <h1 className="text-4xl font-black text-transparent bg-clip-text bg-gradient-to-r from-[#89b4fa] to-[#cba6f7] drop-shadow">ESPE RPG System</h1>
          
          {/* Custom Creation Form */}
          <div className="bg-[#11111b] p-5 rounded-xl border border-[#313244] text-left flex flex-col gap-3">
            <h2 className="text-[#cdd6f4] font-bold text-sm">Crear Nuevo Personaje</h2>
            <input 
              type="text" 
              placeholder="Nombre..."
              className="w-full bg-[#1e1e2e] border border-[#313244] text-sm text-[#cdd6f4] rounded p-3 focus:outline-none focus:border-[#89b4fa] transition-all"
              value={newName}
              onChange={(e) => setNewName(e.target.value)}
            />
            <select 
              className="w-full bg-[#1e1e2e] border border-[#313244] text-sm text-[#cdd6f4] rounded p-3 focus:outline-none"
              value={newClass}
              onChange={(e) => setNewClass(e.target.value)}
            >
              <option value="Warrior">Warrior</option>
              <option value="Mage">Mage</option>
            </select>
            <button 
              onClick={handleCreateCustom}
              disabled={isLoading || !newName.trim()}
              className="w-full py-3 bg-[#89b4fa] text-[#11111b] font-black rounded text-sm hover:scale-[1.02] hover:bg-[#b4befe] hover:shadow-lg hover:shadow-[#89b4fa]/20 transition-all disabled:opacity-50"
            >
              Crear Personaje
            </button>
          </div>

          <div className="flex items-center justify-between text-xs text-[#585b70] my-2">
            <span className="w-1/3 h-px bg-[#313244]"></span>
            <span>O</span>
            <span className="w-1/3 h-px bg-[#313244]"></span>
          </div>
          
          <button 
            onClick={handleCreateDemo}
            disabled={isLoading}
            className="w-full px-6 py-3 bg-[#cba6f7] text-[#11111b] font-black rounded text-sm hover:scale-[1.02] hover:bg-[#f5c2e7] hover:shadow-lg hover:shadow-[#cba6f7]/20 transition-all disabled:opacity-50"
          >
            {isLoading ? 'Cargando...' : 'Nueva Partida Demo'}
          </button>
          
          {savedGames.length > 0 && (
            <div className="pt-6 border-t border-[#313244] text-left">
              <h2 className="text-[#a6adc8] mb-3 text-xs font-bold uppercase tracking-wider">Cargar Partida Existente:</h2>
              <select 
                className="w-full bg-[#11111b] border border-[#45475a] text-[#cdd6f4] rounded p-3 mb-3 focus:outline-none"
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
                className="w-full px-6 py-3 bg-[#f9e2af] text-[#11111b] font-black rounded text-sm hover:scale-[1.02] hover:opacity-90 hover:shadow-lg hover:shadow-[#f9e2af]/20 transition-all disabled:opacity-50"
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
    <div className="min-h-screen bg-[#1e1e2e] text-[#cdd6f4] p-6 font-sans flex flex-col items-center">
      <div className="w-full max-w-[1050px] flex flex-col gap-6">
        
        {/* Header */}
        <div className="border-b border-[#313244] pb-4 flex items-center justify-between">
          <h1 className="text-3xl font-black text-transparent bg-clip-text bg-gradient-to-r from-[#89b4fa] to-[#cba6f7] drop-shadow-md">
            ESPE RPG System
          </h1>
          <span className="text-xs font-bold bg-[#313244] text-[#a6e3a1] px-3 py-1.5 rounded-full shadow border border-[#45475a]">
            ● Conectado a MongoDB
          </span>
        </div>

        {/* 3 Columns Layout */}
        <div className="flex gap-5">
          
          {/* LEFT COLUMN: Control Panel, Persistence, Log */}
          <div className="w-[280px] flex flex-col gap-5 shrink-0">
            
            {/* Create Custom */}
            <div className="bg-[#181825] p-5 rounded-2xl border border-[#313244] shadow-xl flex flex-col gap-3">
              <h2 className="text-white font-black text-sm border-b border-[#313244] pb-2">Crear Nuevo Personaje</h2>
              <input 
                type="text" 
                placeholder="Nombre..."
                className="w-full bg-[#11111b] border border-[#313244] text-xs text-[#cdd6f4] rounded p-2 focus:outline-none focus:border-[#89b4fa] transition-all"
                value={newName}
                onChange={(e) => setNewName(e.target.value)}
              />
              <select 
                className="w-full bg-[#11111b] border border-[#313244] text-xs text-[#cdd6f4] rounded p-2 focus:outline-none"
                value={newClass}
                onChange={(e) => setNewClass(e.target.value)}
              >
                <option value="Warrior">Warrior</option>
                <option value="Mage">Mage</option>
              </select>
              <button 
                onClick={handleCreateCustom}
                disabled={isLoading || !newName.trim()}
                className="w-full py-2 bg-[#89b4fa] text-[#11111b] font-black rounded text-xs hover:scale-[1.02] hover:bg-[#b4befe] hover:shadow-md hover:shadow-[#89b4fa]/20 transition-all disabled:opacity-50"
              >
                Crear Personaje
              </button>
            </div>

            {/* Persistence Card */}
            <div className="bg-[#181825] p-5 rounded-2xl border border-[#313244] shadow-xl flex flex-col gap-3">
              <h2 className="text-white font-black text-sm border-b border-[#313244] pb-2">Persistencia (MongoDB)</h2>
              
              <select 
                className="w-full bg-[#11111b] border border-[#45475a] text-xs text-[#cdd6f4] rounded p-2 focus:outline-none"
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
                className="w-full py-2 bg-[#f9e2af] text-[#11111b] font-black rounded text-xs hover:scale-[1.02] hover:shadow-md hover:shadow-[#f9e2af]/20 transition-all disabled:opacity-50"
              >
                Cargar Partida
              </button>
              <button 
                onClick={handleSaveGame}
                disabled={isLoading}
                className="w-full py-2 bg-[#a6e3a1] text-[#11111b] font-black rounded text-xs hover:scale-[1.02] hover:bg-[#abe9b3] hover:shadow-md hover:shadow-[#a6e3a1]/20 transition-all disabled:opacity-50"
              >
                Guardar Partida
              </button>
              
              <hr className="border-[#313244] my-1" />
              
              <button 
                onClick={handleRest}
                disabled={isLoading}
                className="w-full py-2 bg-[#89dceb] text-[#11111b] font-black rounded text-xs hover:scale-[1.02] hover:bg-[#74c7ec] hover:shadow-md hover:shadow-[#89dceb]/20 transition-all disabled:opacity-50"
              >
                ⛺ Descansar (Curar)
              </button>
            </div>

            {/* Event Log */}
            <div className="bg-[#181825] p-5 rounded-2xl border border-[#313244] shadow-xl flex-1 flex flex-col min-h-[220px]">
              <h2 className="text-white font-black text-sm border-b border-[#313244] pb-2 mb-3">Registro de Eventos</h2>
              <div className="flex-1 bg-[#11111b] p-3 rounded-lg overflow-y-auto text-xs font-mono border border-[#313244] flex flex-col-reverse gap-1.5 scrollbar-thin">
                {log.map((entry, i) => (
                  <div key={i} className={`${getLogColorClass(entry)} transition-all hover:bg-[#1e1e2e] p-1 rounded`}>
                    {`> ${entry}`}
                  </div>
                ))}
              </div>
            </div>
          </div>

          {/* CENTER COLUMN: Player Stats & Combat */}
          <div className="w-[400px] flex flex-col gap-5 shrink-0">
            {/* Player Stats */}
            <div className="bg-[#181825] p-5 rounded-2xl border border-[#313244] shadow-xl flex flex-col gap-4">
              <h2 className="text-white font-black text-sm border-b border-[#313244] pb-2">Tu Personaje</h2>
              
              <div className="flex gap-4 items-center">
                <div 
                  className="w-20 h-20 bg-[#313244] rounded-xl border-2 border-[#cba6f7] flex items-center justify-center overflow-hidden shadow-inner cursor-pointer hover:scale-105 transition-all"
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
                  <div className="text-2xl font-black text-white">{character.name}</div>
                  <span className="text-xs font-bold bg-[#313244] text-[#bac2de] px-3 py-1 rounded-full shadow border border-[#45475a] mt-1.5 inline-block">
                    {character.type} | EXP: {character.exp}/100
                  </span>
                </div>
              </div>

              {/* HP Bar */}
              <div>
                <div className="text-xs text-[#a6adc8] mb-1 font-bold">Salud Vital (HP)</div>
                <div className="h-4 bg-[#313244] rounded-full overflow-hidden relative shadow-inner border border-[#45475a]">
                  <div 
                    className="h-full transition-all" 
                    style={{ width: `${hpPercent}%`, backgroundColor: hpColor }}
                  ></div>
                </div>
                <div className="text-xs text-right mt-1 text-[#bac2de] font-bold">{character.hp.toFixed(0)} / {character.maxHp.toFixed(0)}</div>
              </div>

              {/* Attributes */}
              <div className="flex justify-between border-b border-[#313244] pb-3">
                <div>
                  <div className="text-xs text-[#a6adc8] font-bold">Atributo Primario</div>
                  <div className="text-lg text-white font-black font-mono">{character.primaryStatStr}</div>
                </div>
                <div className="text-right">
                  <div className="text-xs text-[#a6adc8] font-bold">Recurso Especial</div>
                  <div className="text-lg text-[#cba6f7] font-black font-mono">{character.secondaryStatStr}</div>
                </div>
              </div>

              {/* Combat Stats */}
              <div className="flex justify-between border-b border-[#313244] pb-3">
                <div>
                  <div className="text-xs text-[#a6adc8] font-bold">Bonus Daño</div>
                  <div className="text-lg text-white font-black font-mono">+{character.bonusDamage.toFixed(1)}</div>
                </div>
                <div className="text-right">
                  <div className="text-xs text-[#a6adc8] font-bold">Defensa</div>
                  <div className="text-lg text-white font-black font-mono">+{character.bonusDefense.toFixed(1)}</div>
                </div>
              </div>

              {/* Active Equipment */}
              <div>
                <h3 className="text-xs font-bold uppercase tracking-wider text-[#a6adc8] mb-3">Equipamiento Activo</h3>
                <div className="grid grid-cols-3 gap-2">
                  {Object.entries(character.equipped).map(([slot, itemName]) => {
                    let imgPath = null;
                    if (itemName) {
                      const s = slot.toLowerCase();
                      if (s.includes('weapon')) imgPath = '/images/weapon.png';
                      else if (s.includes('helmet')) imgPath = '/images/helmet.png';
                      else if (s.includes('chest')) imgPath = '/images/chest.png';
                      else if (s.includes('legs')) imgPath = '/images/legs.png';
                      else if (s.includes('boots')) imgPath = '/images/boots.png';
                      else if (s.includes('ring')) imgPath = '/images/ring.png';
                      else if (s.includes('amulet')) imgPath = '/images/amulet.png';
                    }

                    return (
                      <div 
                        key={slot} 
                        onClick={() => itemName && handleUnequip(slot)}
                        className={`h-[72px] w-full rounded-xl flex flex-col items-center justify-center p-1.5 text-center cursor-pointer transition-all relative overflow-hidden group select-none ${
                          itemName 
                            ? 'bg-[#45475a] border-2 border-[#cba6f7] hover:border-[#f38ba8] hover:scale-105 hover:shadow-lg hover:shadow-[#f38ba8]/15' 
                            : 'bg-[#313244] border border-[#45475a] hover:border-[#bac2de]'
                        }`}
                        onDrop={handleDrop}
                        onDragOver={handleDragOver}
                        title={itemName ? `${itemName} (Click para desequipar)` : `Arrastra aquí para equipar ${slot}`}
                      >
                        {imgPath && itemName && (
                          <img src={imgPath} className="absolute inset-0 w-full h-full object-contain opacity-25 pointer-events-none group-hover:scale-110 transition-all" alt={slot} />
                        )}
                        <div className="text-[9px] text-[#bac2de] uppercase z-10 font-bold">{slot}</div>
                        <div className="text-[10px] text-white font-black break-words z-10 line-clamp-2 mt-0.5 leading-tight">{itemName || '-'}</div>
                      </div>
                    );
                  })}
                </div>
              </div>
            </div>

            {/* Combat Zone */}
            <div className="bg-[#181825] p-5 rounded-2xl border-2 border-[#f38ba8] shadow-xl shadow-[#f38ba8]/5 flex flex-col gap-4">
              <h2 className="text-[#f38ba8] font-black text-sm border-b border-[#313244] pb-2">Zona de Combate</h2>
              <div className="flex gap-4 items-center p-3 bg-[#313244]/50 rounded-xl border border-[#45475a]">
                <div className="w-14 h-14 bg-[#181825] rounded-lg border-2 border-[#f38ba8] overflow-hidden flex items-center justify-center">
                  <img src="/images/enemy.png" alt="Enemy" className="w-full h-full object-cover" onError={(e) => { e.currentTarget.style.display = 'none'; e.currentTarget.parentElement!.innerHTML = '👹'; }} />
                </div>
                <div>
                  <div className="text-white font-black text-md">Monstruo Feroz</div>
                  <div className="text-xs text-[#a6adc8] font-bold bg-[#45475a] px-2 py-0.5 rounded-full inline-block mt-1">Enemigo Activo</div>
                </div>
              </div>
              <button 
                onClick={handleAttack}
                disabled={isLoading}
                className="w-full py-3 bg-[#f38ba8] text-[#11111b] font-black rounded-lg hover:scale-[1.02] hover:bg-[#f5c2e7] hover:shadow-lg hover:shadow-[#f38ba8]/20 transition-all disabled:opacity-50"
              >
                ⚔️ Atacar Enemigo
              </button>
            </div>
          </div>

          {/* RIGHT COLUMN: Inventory */}
          <div className="w-[280px] flex flex-col shrink-0">
            <div className="bg-[#181825] p-5 rounded-2xl border border-[#313244] shadow-xl flex-1 flex flex-col gap-4">
              <div>
                <h2 className="text-white font-black text-sm border-b border-[#313244] pb-2">Mochila (Inventario)</h2>
                <p className="text-[10px] text-[#a6adc8] mt-1 font-bold">Arrastra items al personaje para usarlos</p>
              </div>
              
              <div className="flex-1 overflow-y-auto flex flex-col gap-2 max-h-[460px] pr-1.5 scrollbar-thin">
                {character.inventory.map((item, idx) => {
                  const imgSrc = getImageForItem(item);
                  return (
                    <div 
                      key={`${item.id}-${idx}`}
                      draggable
                      onDragStart={(e) => handleDragStart(e, item.id)}
                      className="bg-[#313244] p-3 rounded-xl cursor-grab border border-[#45475a] hover:border-[#cba6f7] hover:scale-[1.03] hover:shadow-md hover:shadow-[#cba6f7]/10 flex gap-3 items-center transition-all"
                    >
                      {imgSrc && (
                        <div className="w-11 h-11 bg-[#181825] rounded-lg p-1.5 shrink-0 border border-[#45475a]">
                          <img src={imgSrc} alt={item.name} className="w-full h-full object-contain" />
                        </div>
                      )}
                      <div className="min-w-0 flex-1">
                        <div className="text-xs font-black text-white truncate">{item.name}</div>
                        <div className="text-[10px] text-[#bac2de] truncate leading-tight mt-0.5">{item.desc}</div>
                        <div className="text-[9px] text-[#cba6f7] font-bold uppercase tracking-wider mt-1">{item.classType}</div>
                      </div>
                    </div>
                  );
                })}
                {character.inventory.length === 0 && (
                  <div className="text-xs text-[#585b70] text-center p-8 bg-[#11111b] rounded-xl border border-dashed border-[#313244]">Mochila Vacía</div>
                )}
              </div>

              <hr className="border-[#313244] my-1" />

              <button 
                onClick={handleLoot}
                disabled={isLoading}
                className="w-full py-3 bg-[#f9e2af] text-[#11111b] font-black rounded-lg hover:scale-[1.02] hover:shadow-lg hover:shadow-[#f9e2af]/20 transition-all disabled:opacity-50"
              >
                🔍 Buscar Botín
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
