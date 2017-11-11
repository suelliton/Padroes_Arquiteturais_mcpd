package com.tads.eaj.ufrn.mcpd.Command;

import android.content.Context;

import com.tads.eaj.ufrn.mcpd.model.Registro;

/**
 * Created by suelliton on 11/11/2017.
 */

public interface Command {
     void execute(Context context,Registro registro);
     void undo();
}
