package br.com.biblia.main;

import br.com.biblia.consult.ConsultBiblia;
import br.com.biblia.data.BibliaData;

public class BibliaMain {
    public static void main(String[] args) {
        ConsultBiblia consultBiblia = new ConsultBiblia();
        BibliaData bibliaData = consultBiblia.consultarBiblia();

        if (bibliaData != null) {
            System.out.println(bibliaData.toString());
        } else {
            System.out.println("Não foi possível obter os dados da Bíblia.");
        }
    }
}
