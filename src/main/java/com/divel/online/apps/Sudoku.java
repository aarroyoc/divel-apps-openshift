package com.divel.online.apps;

import java.util.Random;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


public class Sudoku extends HttpServlet {
	@SuppressWarnings("null")
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException{
		//Sacamos n� aleatorio
		/*Random rnd = new Random();
		resp.setContentType("text/plain");
		//resp.getWriter().println(rnd.nextInt(9));
		int randomnumber=rnd.nextInt(9);
	int sudoku[];
	int linea[][] = {{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0}};
	int columna[][]= {{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0}};
	int cuadro[];
	boolean hecho=false;
	boolean repetido=false;
	int primero=0;
	int segundo=1;
	int comprobacion;
	int sinusarp=1;
	int siunsars=1;
	int hechos=0;
	//Si esta terminado hay un ciclo
	while(hecho==false){
		//Se crea un num aleatorio
		int nuevonumero=rnd.nextInt(8)+1;
		//Hasta que la comprobacion no sea igual a 81 o haya algun repetido
		for(comprobacion=0;comprobacion==81 || repetido==true;comprobacion++){
			//Si l�nea en ese puesto es igual al n�
			if(linea[primero][segundo]==nuevonumero){
				repetido=true; //Es repetido
				
			}else{
				
				//Se comprueba siguiente linea
				if(primero==8){
				primero=0; 
				segundo++;}else{primero++;}
			}
			
		}
		comprobacion=0;
		primero=0; segundo=0;
		for(comprobacion=0;comprobacion==81 || repetido==true;comprobacion++){
			//Si l�nea en ese puesto es igual al n�
			if(columna[primero][segundo]==nuevonumero){
				repetido=true; //Es repetido
				
			}else{
				
				//Se comprueba siguiente linea
				if(primero==8){
				primero=0; 
				segundo++;}else{primero++;}
			}
			
		}
		if(repetido==false)
		{
			linea[sinusarp][siunsars]=nuevonumero;
			
			resp.getWriter().printf("%d",nuevonumero);
			hechos++;
			if(sinusarp==8){sinusarp=0;siunsars++;}else{sinusarp++;}
		}
		if(hechos==81){
			hecho=true;
			
		}
		
		
	}*/
	//Sistema temporal
		
		int sudoku[][]={{9,2,1,/**/3,4,7,/**/8,6,5},
						{3,8,6,/**/5,1,2,/**/4,7,9},
						{4,7,5,/**/6,8,9,/**/1,2,3},
						/**************************/
						{2,1,4,/**/8,3,5,/**/6,9,7},
						{5,3,7,/**/1,9,6,/**/2,4,8},
						{6,9,8,/**/2,7,4,/**/3,5,1},
						/**************************/
						{1,4,2/**/,9,5,3/**/,7,8,6},
						{7,5,3/**/,4,6,8/**/,9,1,2},
						{8,6,9/**/,7,2,1/**/,5,3,4}};
		resp.setContentType("text/html");
		resp.getWriter().println("<!DOCTYPE html><head><title>Sudoku Divel</title>" +
				"<style>" +
				".celda2{border-top: 2px solid 5E93B;border-right: 1px dotted #416D89;border-left:1px dotted #416D89;border-bottom:none;padding-top:10px;padding-right:3px;padding-left:20px;padding-bottom:12px;}" +
				"<script src=//sudoku.js>" +
				"" +
				"" +
				"" +
				"" +
				"" +
				"</style>" +
				"</script>" +
				"" +
				"    <style type=\"text/css\">body{background-image: url(http://divelapps.appspot.com/sudokuCSS.png);background-position : center;background-repeat : no-repeat;background-attachment : fixed;}</style> " +
				"</head>");
		/*resp.getWriter().println("<body>" +
				"<table>" +
				"<tr>" +
				"<td>" + sudoku[0][0] + "<td>"+
				"<td>" + sudoku[0][1] + "<td>"+
				"" +
				"" +
				"" +
				"" +
				""*/
		resp.getWriter().println("<body><form action=procsudoku name=fsudoku>" +
				"<h1>Sudoku</h1><br>" +
				"<p>Enter the correct numbers in the text boxes. You can't submit the sudoku without a number or void, the server going to show a error" +
				"" +
				"" +
				"" +
				"<table border><tr>");
		int ndentrocolumna=0;
		int ndecolumna=0;
		int casilla=1;
		int id=0;
		while(casilla<=81){
			Random azar = new Random();
			//resp.getWriter().println("<br>Inicio bucle n�"+casilla+"<br>");
			if(ndentrocolumna==9){ndentrocolumna=0;ndecolumna++;
				resp.getWriter().println("</tr><tr>");
			
				}
			if(ndecolumna>=9){casilla=81;}
			
		if(azar.nextInt()%9+1==ndentrocolumna){
			resp.getWriter().println("<td><input type=text style=width:5px class=number></input></td>");
			ndentrocolumna++;
			casilla++;
			id++;
		}else{resp.getWriter().printf("<td><div class=megadoku>"+sudoku[ndecolumna][ndentrocolumna]+"</div></td>");
		ndentrocolumna++;
		casilla++;}
		}
		resp.getWriter().println("</tr></table><br>" +
				"<button onclick=Check();>Check my answer</button>" +
				//"<input type=submit></input>" +
				"</form></body></html>");
	}
	}
