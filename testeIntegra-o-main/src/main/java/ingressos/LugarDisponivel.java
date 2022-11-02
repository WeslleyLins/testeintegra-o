package ingressos;

import cliente.Consumidor;

public class LugarDisponivel {

    private float lugarLivre;
    private int qtdLugar;

    public LugarDisponivel(float lugarLivre,int qtdLugar) {
        this.lugarLivre = lugarLivre;
        this.qtdLugar = qtdLugar;
    }

    public float getLugarLivre() {
        return lugarLivre;
    }
    public float getQtdLugar() {
        return qtdLugar;
    }


    public String local(Consumidor inserir, Ingresso ingresso) {
        if (inserir.getQtdCliente() >= 1 && ingresso.getIngresso() == true) {
            this.lugarLivre = getQtdLugar() - inserir.getQtdCliente();
            return "Lugar Comprado";
        } else {
            return "Não foi possivel";
        }
    }

    public boolean localLivre(Consumidor inserir, Ingresso ingresso){
        if (local(inserir,ingresso) == "Lugar Comprado") {
            if (getLugarLivre() >= 1) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }

    }




}
