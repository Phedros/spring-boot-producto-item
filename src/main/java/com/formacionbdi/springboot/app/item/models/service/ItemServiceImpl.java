package com.formacionbdi.springboot.app.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;

@Service("serviceRestTemplate")          //registramos la clase como componente de spring con Service. Service es del stereotico component, asi que marcamos la clase  como un beans de spring
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate clienteRest;     //para conectar con otro microservicio
	
	@Override
	public List<Item> findAll() {                                                 //ruta           //tipo en que lo queremos obtener
		List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));   //se pone una ruta url y despues un arreglo de productos en responseType //utilizando clienteRest se busca getForObjet \  Con Array.asList lo pasamos a lista 
		
		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());    //retorna producto(incompatible con lista), se transforma con metodo stream()  usamos .map para cambiar cada producto a item con exprecion lamda. con collector los pasamos a lista             
	}  //

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);  //con un map pasamos el id y su valor
		return new Item(producto, cantidad);
	}

}

 