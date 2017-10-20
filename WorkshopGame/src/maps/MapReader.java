package maps;

import elements.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class MapReader {

    private Game game;

    private static final String MAP_NAME = "resources/map-level-one";

    public MapReader(Game game) {
        this.game = game;
    }

    public void read() throws Exception {
        BufferedReader bf =
                new BufferedReader(
                        new FileReader(
                                new File(MAP_NAME)
                        )
                );

        String line = null;
        int row = 0;
        while((line = bf.readLine()) != null) {
            this.game.getMap().add(new ArrayList<Element>());
            for (int i = 0; i < line.length(); i++) {
                elements.Element e = elements.ElementFactory.create(line.charAt(i), row, i, this.game);
                this.game.getMap().get(row).add(e);
            }
            row++;
        }
        String x = "";
    }
}
