//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Park> parks  = List.of(
                new Park("Abc National Park", "11.111, 111.111"),
                new Park("Xyz Park", "22.22, 110.010")
                );

        List<River> rivers= List.of(
                new River("Qwerty River", "34.2345, 101.23", "32.4354, 466.2323", "534.23, 12.244"),
                new River("Astic River", "23.4354, 434.2323", "23.4545, 100.323", "22.222, 1.323")
        );

        Layer<Park> parkLayer = new Layer<>();
        parkLayer.addElements(parks);

        Layer<River> riverLayer = new Layer<>();
        riverLayer.addElements(rivers);

        // Render layers
        System.out.println("Rendering Parks Layer:");
        parkLayer.renderLayer();

        System.out.println("\nRendering Rivers Layer:");
        riverLayer.renderLayer();
    }
}
