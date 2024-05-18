package com.example.spotify.scrobbler.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO: REMOVER HASHMAP E MAP DOS IMPORTS, TAO AI PRA TESTE
//TODO: REMOVER CORS DAQUI E AJUSTAR AS PERMISSOES DE VERDADE NA CLASSE PROPRIA DELE

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RankingController {

    private RankingData rankingData;

    @PostMapping("/upload-json")
    public String uploadJson(@RequestParam("file") MultipartFile file) {
        try {
            // Convertendo o conteudo do json pra string
            String jsonContent = new String(file.getBytes());

            // Parseando o json pra um jsonElement
            JsonArray jsonArray = JsonParser.parseString(jsonContent).getAsJsonArray();

            // rodando oq ta dentro do array
            for (JsonElement element : jsonArray) {
                processarJson(element.toString());
            }

            return "Arquivo JSON processado com sucesso!";
        } catch (IOException e) {
            return "Erro ao ler o conteúdo do arquivo JSON: " + e.getMessage();
        }
    }

    @GetMapping("/ranking")
    public RankingData getRanking() {
        if (rankingData == null) {
            throw new RuntimeException("O ranking ainda não foi processado");
        }
        return rankingData;
    }

    @GetMapping("/artist-ranking")
    public List<Pair<String, Integer>> getArtistRanking() {
        if (rankingData.getArtistRanking() == null) {
            throw new RuntimeException("O ranking ainda não foi processado");
        }
        return rankingData.getArtistRanking();
    }

    @GetMapping ("/album-ranking")
    public List<Pair<String, Integer>> getAlbumRanking(){
        if(rankingData.getAlbumRanking() == null){
            throw new RuntimeException("O ranking ainda não foi processado");
        }
        return rankingData.getAlbumRanking();
    }

    @GetMapping ("/track-ranking")
    public List<Pair<String, Integer>> getTrackRanking(){
        if(rankingData.getTrackRanking() == null){
            throw new RuntimeException("O ranking ainda não foi processado");
        }
        return rankingData.getTrackRanking();
    }

    /*@GetMapping("/oi")
    public String getBrother(){
        return "oi";
    }*/
//alo
    @GetMapping("/oi")
    public Map<String, String> getBrother() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "oi");
        return response;
    }


    // Metodo q processa o json e incrementa os rankings
    private void processarJson(String json) {
        // Parseando o json pra um jsonElement
        JsonElement jsonElement = JsonParser.parseString(json);

        if (!jsonElement.isJsonNull()) {
            if (rankingData == null) {
                rankingData = new RankingData();
            }

            // Verifica se o json possui o objeto
            if (jsonElement.getAsJsonObject().has("master_metadata_album_artist_name")) {
                // pega o nome correspondente
                JsonElement artistNameElement = jsonElement.getAsJsonObject().get("master_metadata_album_artist_name");
                if (!artistNameElement.isJsonNull()) {
                    String artistName = artistNameElement.getAsString();
                    // Incrementa o ranking
                    rankingData.incrementArtistCount(artistName);
                }
            }
            if (jsonElement.getAsJsonObject().has("master_metadata_track_name")) {
                JsonElement trackNameElement = jsonElement.getAsJsonObject().get("master_metadata_track_name");
                if (!trackNameElement.isJsonNull()) {
                    String trackName = trackNameElement.getAsString();
                    rankingData.incrementTrackCount(trackName);
                }
            }
            if (jsonElement.getAsJsonObject().has("master_metadata_album_album_name")) {
                JsonElement albumNameElement = jsonElement.getAsJsonObject().get("master_metadata_album_album_name");
                if (!albumNameElement.isJsonNull()) {
                    String albumName = albumNameElement.getAsString();
                    rankingData.incrementAlbumCount(albumName);
                }
            }
        }
    }

    /* Processa o json e incrementa os rankings (ANTIGO)
    private void processarElemento(JsonElement element) {
        if (element.getAsJsonObject().has("master_metadata_album_artist_name")
                && element.getAsJsonObject().has("master_metadata_track_name")
                && element.getAsJsonObject().has("master_metadata_album_album_name")) {
            String artistName = element.getAsJsonObject().get("master_metadata_album_artist_name").getAsString();
            String trackName = element.getAsJsonObject().get("master_metadata_track_name").getAsString();
            String albumName = element.getAsJsonObject().get("master_metadata_album_album_name").getAsString();
            rankingData.incrementArtistCount(artistName);
            rankingData.incrementTrackCount(trackName);
            rankingData.incrementAlbumCount(albumName);
        }
    } */
}