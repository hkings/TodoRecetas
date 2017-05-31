package com.example.hkings.todorecetas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Repositorio ficticio de leads
 */
public class LeadsRepository {
    private static LeadsRepository repository = new LeadsRepository();
    private HashMap<String, Lead> leads = new HashMap<>();

    public static LeadsRepository getInstance() {
        return repository;
    }

    private LeadsRepository() {
        saveLead(new Lead("Lomo Saltado", "40 min", "Colombia", R.drawable.lomo));
        saveLead(new Lead("Arroz con Pollo Puertorriqueño", "60 min", "Puerto Rico", R.drawable.pollo));
        saveLead(new Lead("Quesadillas Salvadoreñas", "60 min", "El Salvador", R.drawable.quesadillas));
        saveLead(new Lead("Very Berry Agua Fresca", "5 min", "grecia", R.drawable.berry));
        saveLead(new Lead("Lomo Saltado", "40 min", "Colombia", R.drawable.lomo));
        saveLead(new Lead("Arroz con Pollo Puertorriqueño", "60 min", "Puerto Rico", R.drawable.pollo));
        saveLead(new Lead("Quesadillas Salvadoreñas", "60 min", "El Salvador", R.drawable.quesadillas));
        saveLead(new Lead("Very Berry Agua Fresca", "5 min", "grecia", R.drawable.berry));
        saveLead(new Lead("Lomo Saltado", "40 min", "Colombia", R.drawable.lomo));
        saveLead(new Lead("Arroz con Pollo Puertorriqueño", "60 min", "Puerto Rico", R.drawable.pollo));
    }

    private void saveLead(Lead lead) {
        leads.put(lead.getId(), lead);
    }

    public List<Lead> getLeads() {
        return new ArrayList<>(leads.values());
    }
}
