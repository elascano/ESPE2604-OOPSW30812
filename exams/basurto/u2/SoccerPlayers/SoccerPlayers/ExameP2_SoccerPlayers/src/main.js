import { SoccerPlayerView } from './view.js';
import { SoccerPlayerController } from './controller.js';

document.addEventListener('DOMContentLoaded', () => {
    const view = new SoccerPlayerView();
    const controller = new SoccerPlayerController(view);
    controller.init();
});