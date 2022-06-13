package fr.univartois.butinfo.sae.projetventes.model.reseau.graph;

import java.util.Iterator;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.DepthFirstIterator;

import fr.univartois.butinfo.sae.projetventes.model.reseau.Arete;
import fr.univartois.butinfo.sae.projetventes.model.reseau.Point;
import fr.univartois.butinfo.sae.projetventes.model.reseau.ReseauRoutier;


/**
 * Cette classe donne un exemple d'utilisation des classes {@code Point}, {@code Arete}, {@code RéseauRoutier}.
 * <p>
 * </p>
 * Les classes {@code Point}, {@code Arete}, {@code RéseauRoutier} sont utilisées pour alimenter la librairie <a href="https://jgrapht.org/">{@link JGraphT}</a>.
 */
public class DessineGraph {
    public static void main(String[] args) {
        // création d'une instance de la classe ReseauRoutier
        ReseauRoutier reseau = new ReseauRoutier();
        // Lecture du fichier contenant la description du réseau routier
        reseau.lireCarte("reseau.txt");

        reseau.construireGraph(reseau);
        
        // Parcours du graphe et affichage pour chaque point des points reliés par une arête
        Iterator<Point> iter = new DepthFirstIterator<>(g);
        while (iter.hasNext()) {
            Point vertex = iter.next();
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Vertex %d is connected to %d neighbour(ors) : %n",vertex.getId(), g.outgoingEdgesOf(vertex).size()));
            for (DefaultWeightedEdge e : g.outgoingEdgesOf(vertex)) {
                sb.append(String.format("%d : %5.2f%n", g.getEdgeTarget(e).getId(), g.getEdgeWeight(e)));
            }
            System.out.println(sb.toString());
        }
    }
}

