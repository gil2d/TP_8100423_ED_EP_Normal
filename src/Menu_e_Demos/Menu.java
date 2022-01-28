/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu_e_Demos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import static javafx.application.Platform.exit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */
public class Menu 
{
    /**
     * Variaveis
     */
    
    String path = "./src/JSON_FILES/CreateJSONFile.json";

    /**
     * Construtor
     */
    public Menu() 
    {
        
    }
    
    /**
     * Menu Principal
     */
    public void MenuGeral() throws org.json.simple.parser.ParseException
    {
        Scanner choice = new Scanner(System.in);
        
        System.out.println("******MENU******\n");
        System.out.println("ESCOLHA UMA DAS SEGUINTES OPÇÕES:\n\n");
        System.out.println("1 - Empresa");
        System.out.println("2 - Vendedores");
        System.out.println("3 - Mercados");
        System.out.println("4 - Armazéns");
        System.out.println("5 - Rotas");
        System.out.println("6 - Carregar ficheiro existente");
        System.out.println("7 - Sair");
        System.out.println("\n****************");
        
        int opcao = choice.nextInt();
        
        switch(opcao){
            case 1:
                MenuEmpresa();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                exit();
                break;
            default:
                System.out.println("Opção Invalida");
                MenuGeral();
                break;
        
        }
        
    }
    /**
     * Menu Empresa
     */
    public void MenuEmpresa() throws org.json.simple.parser.ParseException
    {
        
        Scanner choice = new Scanner(System.in);
        
        System.out.println("******MENU EMPRESA******\n");
        System.out.println("ESCOLHA UMA DAS SEGUINTES OPÇÕES:\n\n");
        System.out.println("1 - Criar/Editar informação dos vendedores");
        System.out.println("2 - Criar/Editar informação dos mercados");
        System.out.println("3 - Criar/Editar informação dos armazéns");
        System.out.println("4 - Criar/Editar informação dos caminhos existentes entre locais");
        System.out.println("5 - Listar vendedores, mercados, armazéns e caminhos");
        System.out.println("6 - Exportar JSON com informação da empresa");
        System.out.println("7 - Voltar ao menu anterior");
        System.out.println("8 - Sair da aplicação");
        System.out.println("\n************************");
        
        int opcao = choice.nextInt();
        
        switch(opcao){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                apresentaListagem_Dados_Empresa();
                break;
            case 6:
                break;
            case 7:
                MenuGeral();
                break;
            case 8:
                exit();
                break;
            default:
                System.out.println("Opção Invalida");
                MenuGeral();
                break;
        }
    }
    
    /**
     * Ponto 5 do Menu Empresa (Listar vendedores,mercados, armazéns e caminhos)
     */
    public static String getListagem_Dados_Empresa(String filename) 
    {
        String jsonText = "";
        
        
        try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
                
                String line;
                
                while((line = bufferedReader.readLine()) != null)
                {
                    jsonText += line+"\n";
                }
                bufferedReader.close();
        } catch (Exception e) 
        {e.printStackTrace();}
        
        return jsonText;
    }
    
    public void apresentaListagem_Dados_Empresa()
    {
        String strJson = getListagem_Dados_Empresa(path);
        
        try 
        {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(strJson);
            JSONObject mainJsonObject = (JSONObject) object;
            
            /***********************Vendedores***********************/
            JSONArray jsonArrayVendedores = (JSONArray) mainJsonObject.get("vendedores");
            System.out.println("VENDEDORES: \n");
            
            for(int i = 0; i < jsonArrayVendedores.size();i++)
            {
                JSONObject jsonVendedor = (JSONObject) jsonArrayVendedores.get(i);
                
                String id = jsonVendedor.get("id").toString();
                System.out.println("Vendedor: "+id);
                String capacidade = jsonVendedor.get("capacidade").toString();
                System.out.println("Capacidade: "+capacidade);
                System.out.println("Mercados a visitar:");
                JSONArray jsonArrayMercados = (JSONArray) jsonVendedor.get("mercados a visitar");
                for(int y = 0; y < jsonArrayMercados.size();y++)
                {
                    String mercados = jsonArrayMercados.get(y).toString();
                    System.out.println("\tMercados: "+mercados);
                }
                System.out.println("");
            }
            
            /***********************Mercados***********************/
            JSONArray jsonArrayMercados = (JSONArray) mainJsonObject.get("locais");
            System.out.println("Mercados: \n");
            
            for(int i = 0; i < jsonArrayMercados.size();i++)
            {
                JSONObject jsonMercados = (JSONObject) jsonArrayMercados.get(i);
                String nome = jsonMercados.get("nome").toString();
                
                if(jsonMercados.size() == 3)
                {
                    System.out.println("\tNome do Mercado: "+nome);
                    
                    JSONArray jsonArrayClientes = (JSONArray) jsonMercados.get("clientes");
                    for(int y = 0; y < jsonArrayClientes.size();y++)
                    {
                        String clientes = jsonArrayClientes.get(y).toString();
                        System.out.println("\tCliente: "+clientes);
                    }
                    
                }
            }
            
            System.out.println("");
            
            /***********************Armazens***********************/
            System.out.println("Armazens: ");
            
            for(int i = 0; i < jsonArrayMercados.size();i++)
            {
                JSONObject jsonMercados = (JSONObject) jsonArrayMercados.get(i);
                String nome = jsonMercados.get("nome").toString();
                if(jsonMercados.size() == 4)
                {
                    String capacidade = jsonMercados.get("capacidade").toString();
                    String stock = jsonMercados.get("stock").toString();
                    System.out.println("\tNome do Armazem: "+nome);
                    System.out.println("\tCapacidade: "+capacidade);
                    System.out.println("\tCapacidade do stock: "+stock+"\n");
                }
            }
            
            /***********************Caminhos***********************/
            JSONArray jsonArrayCaminhos = (JSONArray) mainJsonObject.get("caminhos");
            System.out.println("Caminhos: ");
            
            for(int i = 0; i < jsonArrayCaminhos.size();i++)
            {
            
            }
            
        } catch (Exception e) 
        {e.printStackTrace();}
    }
}
