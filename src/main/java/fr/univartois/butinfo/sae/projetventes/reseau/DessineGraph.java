package fr.univartois.butinfo.sae.projetventes.reseau;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.tour.HeldKarpTSP;
import org.jgrapht.alg.tour.RandomTourTSP;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import com.mxgraph.util.mxCellRenderer;


/**
 * Cette classe donne un exemple d'utilisation des classes {@code Point}, {@code Arete}, {@code RéseauRoutier}.
 * <p>
 * </p>
 * Les classes {@code Point}, {@code Arete}, {@code RéseauRoutier} sont utilisées pour alimenter la librairie <a href="https://jgrapht.org/">{@link JGraphT}</a>.
 */
public class DessineGraph {
	
	public static ReseauRoutier construireReseau() {
		// création d'une instance de la classe ReseauRoutier
        ReseauRoutier reseau = new ReseauRoutier();
        // Lecture du fichier contenant la description du réseau routier
        reseau.lireCarte("./reseau.txt");
		return reseau;
        
	}

	//Méthode qui me sert a afficher a graphe, enfin plutôt a sauvegarder une image png du graphe
	public static Graph<Point, DefaultWeightedEdge> construireGraphe(ReseauRoutier r) {
        // Création d'une représentation du réseau routier sous la forme d'une classe de la librairie JGraphT
        Graph<Point, DefaultWeightedEdge> g = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		// Stockage des points et des arêtes du réseau routier dans le graphe de la librairie JGraphT.
        for (Point p : r.getPoints())
        	g.addVertex(p);
        for (Arete a : r.getRoutes()) {
        	// Ajout d'une arête : 2 points et une pondération
        	Graphs.addEdge(g,r.getPointById(a.getIdP1()), r.getPointById(a.getIdP2()), a.getPoids()) ;
        }
        return g;
	}
	
	public static JGraphXAdapter<Point, DefaultWeightedEdge> transformer(Graph<Point, DefaultWeightedEdge> g) {
		JGraphXAdapter<Point, DefaultWeightedEdge> graphAdapter = new JGraphXAdapter<>(g);
		return graphAdapter;
	}

	//Méthode qui me sert a afficher a graphe, enfin plutôt a sauvegarder une image png du graphe
	public static void afficheGraphe(JGraphXAdapter<Point, DefaultWeightedEdge> graphAdapter) {
		BufferedImage image = 
				mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
		File imgFile = new File("./graph2.png");
		//try catch pour éviter de crash si on leve une exception
		try {
			ImageIO.write(image, "PNG", imgFile);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void randomTour(Graph<Point, DefaultWeightedEdge> g) {
		RandomTourTSP<Point, DefaultWeightedEdge> randomTour = new RandomTourTSP<>();

		JGraphXAdapter<Point, DefaultWeightedEdge> graphAdapter = new JGraphXAdapter<>((Graph<Point, DefaultWeightedEdge>)randomTour.getTour(g));

		afficheGraphe(graphAdapter);
	}

	public static void meilleurTour(Graph<Point, DefaultWeightedEdge> g) {
		HeldKarpTSP<Point, DefaultWeightedEdge> tourGraph = new HeldKarpTSP<>();

		//on applique le tour sur le graphe
		JGraphXAdapter<Point, DefaultWeightedEdge> graphAdapter = new JGraphXAdapter<>((Graph<Point, DefaultWeightedEdge>)tourGraph.getTour(g));
		
		afficheGraphe(graphAdapter);
	}
	
    public static void main(String[] args) {
    	ReseauRoutier r = construireReseau();
    	Graph<Point, DefaultWeightedEdge> g = construireGraphe(r);
    	JGraphXAdapter<Point, DefaultWeightedEdge> graphAdapter = transformer(g);
    	afficheGraphe(graphAdapter);
    	randomTour(g);
    	meilleurTour(g);
    }
	
}

