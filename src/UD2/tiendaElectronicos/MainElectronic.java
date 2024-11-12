package UD2.tiendaElectronicos;

import java.util.ArrayList;
import java.util.List;

public class MainElectronic {
    public static void main(String[] args) {
        List<ElectronicProduct> electronicProducts = new ArrayList<>();
        ElectronicProduct ep1 = new ElectronicProduct("ipad",19.3);
        ElectronicProduct ep2 = new ElectronicProduct("laptop",19.3);
        ElectronicProduct ep3 = new ElectronicProduct("phone",19.3);
        ElectronicProduct ep4 = new ElectronicProduct("pc",19.3);
        ElectronicProduct ep5= new ElectronicProduct("airFrier",19.3);
        electronicProducts.add(ep1);
        electronicProducts.add(ep2);
        electronicProducts.add(ep3);
        electronicProducts.add(ep4);
        electronicProducts.add(ep5);
        ElectronicStore electronicStore = new ElectronicStore(electronicProducts);
    }
}
