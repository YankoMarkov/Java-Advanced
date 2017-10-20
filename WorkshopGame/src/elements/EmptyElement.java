package elements;

import workshopGame.Game;

public class EmptyElement extends Element {

    public EmptyElement(Game game) {
        super(game);
    }

    @Override
    public String getType() {
        return "Empty Element";
    }

    @Override
    public boolean moveTo(workshopGame.elements.Player from) throws Exception {
        return true;
    }
}
