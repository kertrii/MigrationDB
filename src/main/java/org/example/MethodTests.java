package org.example;

import org.example.database.Database;
import org.example.database.DatabaseQueryService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MethodTests {
    public static void main(String[] args) {
//        DatabaseQueryService queryService = new DatabaseQueryService();
//
//        System.out.println();

//        List<MaxProjectCountClient> maxProjectCountClients = queryService.findMaxProjectCountClients();
//        for (MaxProjectCountClient maxProjectCountClient : maxProjectCountClients) {
//            System.out.println(maxProjectCountClient);
//        }
//
//        System.out.println();
//
//        List<LongestProject> longestProjects = queryService.findLongestProjects();
//        for (LongestProject longestProject : longestProjects) {
//            System.out.println(longestProject);
//        }
//
//        System.out.println();
//
//        List<MaxSalaryWorker> maxSalaryWorkers = queryService.findMaxSalaryWorkers();
//        for (MaxSalaryWorker maxSalaryWorker : maxSalaryWorkers) {
//            System.out.println(maxSalaryWorker);
//        }
//
//        System.out.println();
//
//        List<YoungestOldestWorkers> youngestOldestWorkers = queryService.findYoungestOldestWorkers();
//        for (YoungestOldestWorkers youngestOldestWorker: youngestOldestWorkers) {
//            System.out.println(youngestOldestWorker);
//        }


        ClientService clientService = new ClientService();

        try {

            long newClientId = clientService.create("Anna");
            System.out.println("New client created with ID: " + newClientId);
            System.out.println();

            List<Client> clientsBeforeDelete = clientService.listAll();
            System.out.println("List of Clients with a new client: " + clientsBeforeDelete);
            System.out.println();

            String clientName = clientService.getById(newClientId);
            System.out.println("Client name: " + clientName);
            System.out.println();

            clientService.setName(newClientId, "Viktoria");
            System.out.println("Client name updated to: " + clientService.getById(newClientId));
            System.out.println();

            clientService.deleteById(newClientId);
            System.out.println("Client deleted with ID: " + newClientId);
            System.out.println();

            List<Client> clientsAfterDelete = clientService.listAll();
            System.out.println("List of Clients after deleting: " + clientsAfterDelete);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
