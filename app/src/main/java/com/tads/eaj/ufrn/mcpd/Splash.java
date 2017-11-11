package com.tads.eaj.ufrn.mcpd;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tads.eaj.ufrn.mcpd.Banco.BancoHelper;
import com.tads.eaj.ufrn.mcpd.Strategy.CalculoVassouraDaBruxa;
import com.tads.eaj.ufrn.mcpd.Builder.CafeCultura;
import com.tads.eaj.ufrn.mcpd.Builder.ConstructorCultura;
import com.tads.eaj.ufrn.mcpd.Builder.Cultura;
import com.tads.eaj.ufrn.mcpd.Builder.MilhoCultura;
import com.tads.eaj.ufrn.mcpd.Strategy.Praga;
import com.tads.eaj.ufrn.mcpd.model.Registro;
import com.tads.eaj.ufrn.mcpd.model.Usuario;

import java.util.List;

public class Splash extends AppCompatActivity {
    BancoHelper bancoHelper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bancoHelper = new BancoHelper(this);
        deletaBanco();
        //bancoHelper.onCreate(bancoHelper.getWritableDatabase());
        preencheBanco();
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {

                mostrarLogin();
            }
        }, 1200);
    }
    public void mostrarLogin(){
        Intent intent = new Intent(Splash.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    public void preencheBanco(){
        preencheCulturas();
        preenchePragas();
        exibeDados();
    }
    public void exibeDados(){

    }
    public void preenchePragas(){

        Praga vassoura = new Praga(0,"Vassoura da Bruxa",4,1);


        vassoura.setCrescimentoSemanal(new CalculoVassouraDaBruxa().calculaCrescimentoPraga(vassoura));


        bancoHelper.savePraga(vassoura);


    }
    public void preencheCulturas(){
        ConstructorCultura constructor = new ConstructorCultura(new CafeCultura());

        constructor.construirCultura();
        Cultura cafe = constructor.getCultura();
        bancoHelper.saveCultura(cafe);

        constructor = new ConstructorCultura(new MilhoCultura());
        constructor.construirCultura();
        Cultura milho = constructor.getCultura();
        bancoHelper.saveCultura(milho);

    }
    public void deletaBanco(){
        List<Cultura> culturas = bancoHelper.findAllCulturas();
        for(Cultura c: culturas){
            bancoHelper.deleteCultura(c);
        }
        List<Praga> pragas = bancoHelper.findAllPragas();
        for(Praga p: pragas){
            bancoHelper.deletePraga(p);
        }
        List<Usuario> usuarios = bancoHelper.findAllUsuarios();
        for(Usuario u: usuarios){
            bancoHelper.deleteUsuario(u);
        }
        List<Registro> registros = bancoHelper.findAllRegistros();
        for(Registro r: registros){
            bancoHelper.deleteRegistro(r);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bancoHelper.close();
    }
}
