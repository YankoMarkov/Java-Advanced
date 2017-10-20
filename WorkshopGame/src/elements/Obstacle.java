package elements;

import workshopGame.Game;

public class Obstacle extends Element {

    public Obstacle(Game game) {
        super(game);
    }

    @Override
    public String getType() {
        return "Obstacle";
    }

    @Override
    public boolean moveTo(workshopGame.elements.Player player) throws Exception {
        throw new Exception("Cannot move to an obstacle");
    }
}
