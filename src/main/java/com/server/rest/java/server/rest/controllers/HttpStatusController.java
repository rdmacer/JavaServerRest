package com.server.rest.java.server.rest.controllers;

import com.server.rest.java.server.rest.classRMD.Book;
import com.server.rest.java.server.rest.classRMD.Video;
import com.server.rest.java.server.rest.classRMD.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/server")

//@RequestMapping(value="/data/{itemid}", method = RequestMethod.GET)

public class HttpStatusController {

  private List<Book> listBook = new ArrayList<Book>();
  private Book libro3;


  @GetMapping("/rest/{Pedido}")

  ResponseEntity<Object> validaPeticion (@PathVariable("Pedido") int Pedido) {
  //ResponseEntity<Object> validaPeticion (@RequestParam(required=false, defaultValue = "0") int Pedido) {
    Book libro = new Book();
    libro.setId(1L);
    libro.setTitle("Shadow of the Empire");

    Video movie = new Video();
    movie.setId(1L);
    movie.setTitle("A new Hope");
    movie.setDirector("George Lucas");

    List<String> edicion = new ArrayList<>();

    edicion.add("Primera");
    edicion.add("Segunda");
    edicion.add("Tercera");

    movie.setEdition(edicion);

    Error error = new Error();
    error.setError_code(400L);
    error.setMessage("Msg Bad Request");

    switch (Pedido)
    {
    case 2:  return new ResponseEntity<>("Retorna String Conforme", HttpStatus.ACCEPTED);
    case 3:  return new ResponseEntity<>(libro,HttpStatus.FOUND);
    case 4:  return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    case 5:  return new ResponseEntity<>("Puerto Errado",HttpStatus.BAD_GATEWAY);
    case 6:  return new ResponseEntity<>(movie,HttpStatus.FOUND);
    case 7:  return new ResponseEntity<>(movie,HttpStatus.ACCEPTED);
    default: return new ResponseEntity<>("Solicitud No Aceptada", HttpStatus.NOT_ACCEPTABLE);
    }
  }

  @RequestMapping(method = RequestMethod.GET, path = "/defaultLibros")
  public List<Book> defaultLibros() {

    Book libro1 = new Book();
    libro1.setId(1L);
    libro1.setTitle("Shadow of the Empire");
    System.out.println("Agrega Libro a Lista -> pid: "+libro1.getId()+"  ptitle: "+libro1.getTitle());

    Book libro2 = new Book();
    libro2.setId(2L);
    libro2.setTitle("The New Republic");
    System.out.println("Agrega Libro a Lista -> pid: "+libro2.getId()+"  ptitle: "+libro2.getTitle());

    listBook.add(libro1);
    listBook.add(libro2);

    return listBook;
  }


  @RequestMapping(method = RequestMethod.GET, path = "/listaLibros")
  public List<Book> listaLibros() {

    return listBook;
  }


  @RequestMapping(method = RequestMethod.GET, path = "/buscaLibro/{id}")
  public Book buscaLibro(@PathVariable Long id){

    for ( Book p : listBook ) {
      if ( p.getId().equals(id)) {
        return p;
      }
    }
    return null;
  }


  @RequestMapping(method = RequestMethod.POST, path = "/creaLibro")
  //public Book add( @RequestParam(value = "id") Long pid,@RequestParam(value = "title") String ptitle) {
  public Book add( @Valid @RequestBody Book libroNew) {

    libro3 = libroNew;
    System.out.println("Se recibe Nuevo Libro -> pid: "+libro3.getId()+"  ptitle: "+libro3.getTitle());

    listBook.add(libro3);

    return libroNew;
  }


  @RequestMapping(method = RequestMethod.DELETE, path = "/eliminaLibro/{id}")
  public Book eliminaLibro(@PathVariable Long id){

    for ( Book p : listBook ) {
      if ( p.getId().equals(id)) {
        System.out.println("Elimina Libro -> pid: "+p.getId()+"  ptitle: "+p.getTitle());
        libro3=p;
        listBook.remove(p);
        return libro3;
      }
    }
    return null;
  }


  @RequestMapping(method = RequestMethod.PUT, path = "/actualizaLibro/{id}")
  public Book modificaLibro(@PathVariable Long id,@RequestBody Book upLibro){

    for ( Book p : listBook ) {
      if ( p.getId().equals(id)) {
        System.out.println("Actualiza Libro -> pid: "+p.getId()+"  ptitle: "+p.getTitle());
        libro3=upLibro;
        listBook.set(listBook.indexOf(p),upLibro);
        System.out.println("Con Libro -> pid: "+upLibro.getId()+"  ptitle: "+upLibro.getTitle());
        return libro3;
      }
    }
    return null;
  }
}

