package app;


import java.util.List;
import java.util.Scanner;

import dao.CarroDAO;
import model.Carro;
import service.CarroService;

import static spark.Spark.*;



public class Aplicacao {
	
	private static CarroService carroService = new CarroService();

	public static void main(String args[])
	{
		port(5500);
		staticFiles.location("/public");
		get("/carros", (req, res) -> {

			return carroService.list(req, res);
		});
			

		post("/carros/inserir", (req, res) -> {
			String id = req.queryParams("id");
			String marca = req.queryParams("marca");
			String modelo = req.queryParams("modelo");
			String ano = req.queryParams("ano");
			String placa = req.queryParams("placa");
			Carro carro = new Carro(Integer.parseInt(id), marca, modelo, Integer.parseInt(ano), placa);
			CarroDAO carroDao = new CarroDAO();
			carroDao.insert(carro);
			res.redirect("/carros");
			return null;
		});

		post("/carros/remover", (req, res) -> {
			
			return carroService.delete(req, res);
			
		});

		post("/carros/atualizar", (req, res) -> {
			
			return carroService.update(req, res);
			
		});

		get("/carros/listar", (req, res) -> {
			
			return carroService.list(req, res);
			
		});
		
		// CarroDAO carroDao = new CarroDAO();
		
		// Scanner sc = new Scanner(System.in);
		
		// int selection = -1;
		
		// while (selection != 5)
		// {
			
		// 	System.out.println("Inserir um número de 1 a 5 para o seguinte menu");
		// 	System.out.println("====MENU===");
		// 	System.out.println("1-INSERIR");
		// 	System.out.println("2-LISTAR");
		// 	System.out.println("3-ATUALIZAR");
		// 	System.out.println("4-EXCLUIR");
		// 	System.out.println("5-SAIR");
			
		// 	selection = sc.nextInt();
			
		// 	Carro carro = new Carro(1, "Ford", "Ka",2020, "PWW-0000");
			
		// 	switch (selection)
		// 	{
		// 		case 1:
		// 			System.out.println("\n\n==== Inserir usuário === ");
		// 			if(carroDao.insert(carro) == true) {
		// 				System.out.println("Inserção com sucesso -> " + carro.toString());
		// 			}
		//             break;
		//         case 2:
		//         	System.out.println("\n\n==== Mostrar usuários ordenados por código === ");
		//     		List<Carro> carros = carroDao.getOrderById();
		//     		for (Carro u: carros) {
		//     			System.out.println(u.toString());
		//     		}
		//             break;
		//         case 3:
		//         	System.out.println("\n\n==== Atualizar entrada (código (" + carro.getId() + ") === ");
		//     		carro = new Carro(1, "Ford", "Focus",2020, "PWW-0000");
		//     		carroDao.update(carro);
		//             break;
		//         case 4:
		//         	System.out.println("\n\n==== Excluir usuário (código " + carro.getId() + ") === ");
		//     		carroDao.delete(carro.getId());
		//             break;
		//         case 5:
		//             System.out.println("Progama Terminado");
		//             break;
		//         default:
		//             System.out.println("Seleção Inválida");
		// 	}
		
		// }		
		
		
	}

}
