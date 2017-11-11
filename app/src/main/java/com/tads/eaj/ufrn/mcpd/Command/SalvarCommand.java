package com.tads.eaj.ufrn.mcpd.Command;

import android.content.Context;

import com.tads.eaj.ufrn.mcpd.Banco.BancoHelper;
import com.tads.eaj.ufrn.mcpd.model.Registro;

/**
 * Created by suelliton on 11/11/2017.
 */

public class SalvarCommand implements Command {
    private String dataUltimo ;
    BancoHelper bancoHelper;
    Context context;

    @Override
    public void execute(Context context, Registro registro) {
        this.context = context;
        this.dataUltimo= registro.getDataRegistro();
        bancoHelper = new BancoHelper(context);
        bancoHelper.saveRegistro(registro);
    }

    @Override
    public void undo() {
        bancoHelper.deleteRegistro((Registro) bancoHelper.execSQL("select from Registro where Registro.dataRegistro="+dataUltimo));

    }
}
