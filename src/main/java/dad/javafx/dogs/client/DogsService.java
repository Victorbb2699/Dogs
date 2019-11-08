package dad.javafx.dogs.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import dad.javafx.dogs.client.messages.BreedsMessage;
import dad.javafx.dogs.client.messages.ImageMessage;

public class DogsService {

	public DogsService() {
		Unirest.setObjectMapper(new UnirestObjectMapper());
	}

	public List<String> listBreeds() throws DogsServiceException {
		try {
			BreedsMessage message = Unirest.get("https://dog.ceo/api/breeds/list").asObject(BreedsMessage.class)
					.getBody();
			if (!message.isSuccess())
				throw new DogsServiceException("Error retrieving breeds");
			return message.getMessage();

		} catch (UnirestException e) {
			throw new DogsServiceException(e);
		}
	}

	public URL randomImageByBreed(String breed) throws DogsServiceException {

		try {
			ImageMessage message = Unirest.get("https://dog.ceo/api/breed/" + breed + "/images/random")
					.asObject(ImageMessage.class).getBody();

			if (!message.isSuccess()) {
				throw new DogsServiceException("Error retrieving" + breed + "random image");
			}
			return new URL(message.getMessage());

		} catch (UnirestException | MalformedURLException e) {
			throw new DogsServiceException(e);
		}

	}



	public URL randomImage() throws DogsServiceException {
		// TODO devolver imagen aleatorioa de cualquier raza

		try {
			ImageMessage message = Unirest.get("https://dog.ceo/api/breeds/image/random").asObject(ImageMessage.class)
					.getBody();

			if (!message.isSuccess()) {
				throw new DogsServiceException("Error retrieving random image");

			}
			return new URL(message.getMessage());

		} catch (UnirestException | MalformedURLException e) {
			throw new DogsServiceException();
		}

	}

	public List<URL> imagesByBreed(String breed) throws DogsServiceException {
		List<URL> lista = new ArrayList<>();
		List<String> listaString = new ArrayList<String>();
		try {
			BreedsMessage message = Unirest.get("https://dog.ceo/api/breed/" + breed + "/images")
					.asObject(BreedsMessage.class).getBody();
			if (!message.isSuccess()) {
				throw new DogsServiceException("Error");
			}
			listaString.addAll(message.getMessage());
			for (int i = 0; i < listaString.size(); i++) {
				lista.add(new URL(listaString.get(i)));
			}
			return lista;
		} catch (UnirestException | MalformedURLException e) {
			throw new DogsServiceException(e);
		}
	}

	public List<String> subBreeds(String breed) throws DogsServiceException {
		// TODO devolver todas las subrazas de la raza indicada
		List<String> lista = new ArrayList<>();
		try {
			BreedsMessage message = Unirest.get("https://dog.ceo/api/breed/" + breed + "/list")
					.asObject(BreedsMessage.class).getBody();

			if (!message.isSuccess()) {
				throw new DogsServiceException("Error retrieving sub-breed " + breed);
			}
			lista.addAll(message.getMessage());
			return lista;

		} catch (UnirestException e) {
			throw new DogsServiceException(e);
		}

	}
	public static void main(String[] args) throws UnirestException, MalformedURLException, DogsServiceException {
		DogsService service = new DogsService();
		System.out.println(service.listBreeds());
		System.out.println(service.randomImage());
		System.out.println(service.randomImageByBreed("akita"));
		System.out.println(service.subBreeds("hound"));
	}
}
