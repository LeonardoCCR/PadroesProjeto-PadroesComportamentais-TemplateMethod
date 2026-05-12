import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Item> items = new ArrayList<>();

    public double calcularValor(){
        double valorFinal = 0.0;

        for(Item item: this.items){
            valorFinal+= item.getValor();
        }
        return valorFinal;
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
