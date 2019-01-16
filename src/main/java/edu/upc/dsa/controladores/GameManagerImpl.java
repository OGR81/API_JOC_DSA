package edu.upc.dsa.controladores;

import edu.upc.dsa.dao.IGameDAO;
import edu.upc.dsa.dao.gameDAOimpl;
import edu.upc.dsa.exceptions.UserNotFoundException;
import edu.upc.dsa.exceptions.WrongPasswordException;
import edu.upc.dsa.modelos.*;
import org.apache.log4j.Logger;

import java.lang.Object;
import java.util.*;
import java.util.Map;


public class GameManagerImpl implements GameManager {
    //

    private static GameManagerImpl instance = null;
    final static Logger logger = Logger.getLogger(GameManagerImpl.class);
    private HashMap<Integer, Enemy> enemies;
    private ArrayList<Game> games;
    private HashMap<Integer, Map> maps;
    private HashMap<Integer, Object> objects;
    private HashMap<Integer, PNJ> pnjs;
    private LinkedList<Position> positions;
    private HashMap<Integer, User> users;

    private IGameDAO dao;

    public GameManagerImpl() {
        this.enemies = new HashMap<>();
        this.games = new ArrayList<>();
        this.maps = new HashMap<>();
        this.objects = new HashMap<>();
        this.pnjs = new HashMap<>();
        this.positions = new LinkedList<>();
        this.users = new HashMap<>();
    }

    //Patron Singleton
    public static GameManagerImpl getInstance() {
        if (instance == null) instance = new GameManagerImpl();
        return instance;
    }

    //USER

    //Afegir un user
    public void addUserBBDD(int idUser, String userName, String password) {
        User user = new User(0, userName, password);
        logger.info("Añadimos un user con los parametros que pedimos");
        this.users.put(idUser, user);
    }

    //public void editUserName(int idUser, String oldUserName, String newUserName);
    public int editPassword(int idUser, String oldPassword, String newPassword) throws WrongPasswordException {
        String oldPass = users.get(idUser).getPassword();
        if (oldPass == oldPassword)
            users.get(idUser).setPassword(newPassword);
        else
            throw new WrongPasswordException();

        return 1;
    }

    public void deleteUser(int idUser, String password) {

    }

    public List<Game> gamesByUser(String userId) throws UserNotFoundException {
        this.dao = gameDAOimpl.getInstance();
        User user = this.users.get(userId);
        logger.info("Buscamos el user...");
        if (user != null) {
            try {
                games.addAll(this.dao.getGames(user.getIdUser()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            //logger.info("Estas son los games jugados por el user: " + user.getGamesFromUser().toString());
            return games;
        } else
            throw new UserNotFoundException();
    }

    public int numUsers() {
        return this.users.size();
    }

    //OBJETO

    /**
     * Ejm: Insert("idObjeto", "Nombre", "idMapa", "idPos", "precio")
     * Insert("1", "Llave", "1", "3", "4")
     */
    public void addObjectBBDD(int idObject, String name, int price, int idPosition, int idMap) {
        //Afegir un ObjectModel
        //PETA -- ObjectModel object = new ObjectModel(idObject, name, price, idPosition, idMap);
        logger.info("Añadimos un object con los parametros que pedimos");

/*      FALTA IMPLEMENTAR
        ObjectDAO objDAO = DAOFactory.getDAOObject();  // new ObjectDAO();
        objDAO.add(object);

        this.objects.put(Integer, object);

        */
    }

    /* NO FUNCIONA
    public int numObjects(String idMap){
        return this.maps.get(idMap)

    }
    */

    public void addObjectHero(int idObject, int idUser, int idGame, int idMapa) {
        /*edu.upc.dsa.modelos.ObjectModel object = this.users.get(idUser).getGameById(idGame).
                getMap().getMapObjects().remove(idObject);
        logger.info("Añadimos un objeto del mapa en el que se encuentra el usuario al usuario");
        this.users.get(idUser).getGameById(idGame).getInventory().put(idObject, object);*/
    }

    //Mapa

    /**
     * Ejm: Insert("numFilas", "numCol", "numObj", "idMap", "numEnemigos")
     * Insert("4", "5", "4", "2", "2")
     * este ejemplo nos crea un mapa de 4x5, con 4 obj 2 enemigos.
     * nosotros como admins, insertamos un enmigo en un cierta posicion.
     * en la tabla de mapas tendremos todos los mapas, no te molaria tener varios tipos de mapas
     * y elegir, aunque solo usemos 2. peero no es mas faena eh, si solo cambiaremos las filas y las
     * columnas. y entonces depues en la tabla de enemigos tenemos en que mapa se encuentra y en q posicion.
     */

    public void addMapBBDD(int idMap, int numEnemies, int numObjects, int numRows, int numColumns) {
        //Afegir un Map
        //PETA -- Map map = new Map(idMap, numEnemies, numObjects, numRows, numColumns);
        logger.info("Añadimos un map con los parametros que pedimos");
        //PETA -- this.maps.put(idMap, Map);
    }

/*    public void addEnemyToMap(int idPosition, int idEnemy, int pain, int speed, int type, int idMap) {
        Enemy enemy = enemies.get(idEnemy);
        enemy.setIdPosition(idPosition);
        *//*PETA -- Enemy enemy2 = this.maps.get(idMap).getMapEnemies().put(idEnemy, enemy);
        if (enemy2 != null)
            logger.info("Añadimos un enemy al mapa que pedimos");
        else
            logger.info("Ha pasado algo al añadir enemigo al map");
            *//*
    }*/


    public void addPNJToMap(int idPosition, int idMap, int idPNJ) {
        PNJ pnj = pnjs.get(idPNJ);
        pnj.setIdPosition(idPosition);
        /*PETA -- PNJ pnj2 = this.maps.getMap(idMap).getMapPNJ().put(idPNJ, PNJ);
        if (pnj2 != null)
            logger.info("Añadimos un PNJ al mapa que pedimos");
        else
            logger.info("Ha pasado algo al añadir enemigo al map");
            */
    }


    public void addObjectToMap(int idObject, String name, int price, int idPosition, int idMap) {
        Object object = enemies.get(idObject);
        //PETA -- object.setIdPosition(idPosition);
        /*PETA -- ObjectModel object2 = this.maps.getMap(idMap).getMapObjects().put(idObject, ObjectModel);
        if (object2 != null)
            logger.info("Añadimos un ObjectModel al mapa que pedimos");
        else
            logger.info("Ha pasado algo al añadir enemigo al map");
            */
    }


    public Enemy getEnemyById(int idEnemy) {

        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (enemy.getIdEnemy() == idEnemy){
                logger.info("Devolvemos enemy que corresponde a la id " + enemy.getIdEnemy());
                return enemy;
            }
        }
        return null;
    }

    public void addEnemyBBDD (int idPosition, int pain, int speed, int type, int idEnemy ){
    }

    public List<String> GetStatsOfEnemy(String enemyId) {
        return null;
    }

    public ArrayList<Enemy> getEnemies() {
        return null;
    }

    public int numEnemies(String idMap) throws Exception{
        return 1;
    }
}



    /*Afegir una station
    public void addStation(String idStation, String description, int max, double lat, double lon) {
        Station station = new Station(idStation,description,max,lat,lon);
        logger.info("Añadimos una station con los parametros que pedimos");
        this.stations.add(station);
    } 

    //Afegir una bike
    public void addBike(String idBike, String description, double kms, String idStation) throws StationFullException, StationNotFoundException{
        Station station = this.getStationById(idStation);
        if (station != null) {
            if (station.getMax() > this.numBikes(idStation)) {
                Bike bike = new Bike(idBike, description, kms, idStation);
                logger.info("Añadimos una bike a la estacion que pedimos");
                this.getStationById(idStation).addBike(bike);
            }
            else
                throw new StationFullException();
        }
        else
            throw new StationNotFoundException();

    }

    

    public List<Bike> bikesByStationOrderByKms(String idStation) throws StationNotFoundException {

        Station station = this.getStationById(idStation);
        if (station != null) {
            ArrayList<Bike> bikesList = station.getBikes();
            logger.info("bikesByStationOrderByKms: ordenando las bikes por kms...");
            logger.info("Lista sin ordenar: " + bikesList.toString());

            //Ordena de menor a Mayor.
            bikesList.sort(Comparator.comparingDouble(Bike::getKms));

            logger.info("Lista ordenada: " + bikesList.toString());
            return bikesList;
        }
        else
            throw new StationNotFoundException();
    }

    public Bike getBike(String stationId, String userId) throws UserNotFoundException, StationNotFoundException {
        //Buscamos la estacion, añadimos una bike al user y borramos la 1a bike de la estacion

        Station station = this.getStationById(stationId);
        if (station != null && !station.getBikes().isEmpty()) {
            logger.info("Buscamos la station...");
            User user = this.users.get(userId);
            logger.info("Buscamos el user...");

            if (user != null) {
                logger.info("Quitamos la bike de la station y la añadimos al user...");
                Bike bike = station.getBikes().remove(0);
                user.addBike(bike);
                return bike;
            }
            else {
                throw new UserNotFoundException();
            }
        } else
            throw new StationNotFoundException();

    }



    public List<Bike> bikesByUser(String userId) throws UserNotFoundException{
        User user = this.users.get(userId);
        logger.info("Buscamos el user...");
        if (user != null) {
            logger.info("Estas son las bikes asignadas al user: " + user.getBikesFromUser().toString());
            return user.getBikesFromUser();
        }
        else
            throw new UserNotFoundException();
    }



    public int numStations() {
        return this.stations.size();
    }

    public int numBikes(String idStation) throws StationNotFoundException {
        Station station = this.getStationById(idStation);
        logger.info("Buscamos la station...");
        if (station != null){
            logger.info("Buscamos el numero de bikes de la station...");
            return station.getBikes().size();
        }
        else
            throw new StationNotFoundException();
    }


    public Station getStationById(String stationId) {

        for (int i = 0; i < stations.size(); i++) {
            Station station = stations.get(i);
            if (station.getIdStation().equals(stationId)){
                logger.info("Devolvemos station que corrsponde a la id " + station.getIdStation());
                return station;
            }
        }
        return null;
    }

    public ArrayList<Station> getStations(){
        String list = "";
        for (Station s : stations)
        {
            list += s.getIdStation() + ", ";

        }
        logger.info("Estas son todas las estaciones disponibles: " + list);
        return this.stations;
    }

    public List<User> getUsers(){
/*        String list = "";
        for (User u : users)
        {
            list += u.getName() + ", ";
        }
        logger.info("Estos son todos los users en el sistema: " );
        *//* 
        Collection<User> collection = this.users.values();
        List<User> aux = new ArrayList<>(collection);

        return aux;
    }

 */


