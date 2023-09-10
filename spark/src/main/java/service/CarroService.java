package service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import dao.CarroDAO;
import model.Carro;
import spark.Request;
import spark.Response;


public class CarroService {

    private CarroDAO carroDao = new CarroDAO();
    private String form;
    
    public CarroService() {
        makeform();
    }


    public void makeform()
    {
        String nomeArquivo = "spark\\src\\main\\resources\\public\\index.html";
        String form = "";

        try{
            Scanner scanner = new Scanner(new File(nomeArquivo));
            while(scanner.hasNext()){
                form += scanner.nextLine() + "\n";
            }
            scanner.close();
        }catch(IOException e){System.out.println(e.getMessage());}
        
        String tabela = "<table class=\"table table-bordered\"> <thread> <tr> <th>ID</th> <th>Fabricante</th> <th>Modelo</th> <th>Ano</th> <th>Placa</th> </tr> </thread";
        tabela += "<tbody class\"table-group-divider\">";
        List<Carro> carros = carroDao.get();

        for(Carro carro : carros){
            tabela += "<tr><td>" + carro.getId() + "</td><td>" + carro.getFabricante() + "</td><td>" + carro.getModelo() + "</td><td>" + carro.getAno() + "</td><td>" + carro.getPlaca() + "</td></tr>";
        }

        tabela += "</tbody>";
        tabela += "</table>";
        this.form = form.replaceFirst("<TABELA>", tabela);


    }
    
    
    
    
    public Object insert(Request request, Response response)
    {
        return carroDao;
    }


    public Object list(Request request, Response response)
    {   
        makeform();
        return form;
    }

    public Object delete(Request request, Response response)
    {
        String id = request.queryParams("id");

        System.out.println(id);
        
        Carro carro = carroDao.get(Integer.parseInt(id));
        carroDao.delete(Integer.parseInt(id));

        makeform();
        return form;
    }

    public Object update(Request request, Response response)
    {
        String id = request.queryParams("id");
        String marca = request.queryParams("marca");
        String modelo = request.queryParams("modelo");
        String ano = request.queryParams("ano");
        String placa = request.queryParams("placa");
        Carro carro = carroDao.get(Integer.parseInt(id));
        carro.setFabricante(marca);
        carro.setModelo(modelo);
        carro.setAno(Integer.parseInt(ano));
        carro.setPlaca(placa);
        carroDao.update(carro);
        makeform();
        return form;

    }

}
