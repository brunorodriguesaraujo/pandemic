package com.example.avaliacaoii.service;

import com.example.avaliacaoii.entity.ResourcesHospital;

import java.util.List;

public abstract class ResourcesAverage {

    protected String getAverageResource(List<ResourcesHospital> list) {
        return "Ambulâncias: " + getAverageAmbulance(list) + "\n" +
                "Médicos: " + getAverageDoctor(list) + "\n" +
                "Respiradores: " + getAverageRespirator(list) + "\n" +
                "Tomógrafos: " + getAverageTomography(list) + "\n" +
                "Enfermeiros: " + getAverageNurse(list);
    }

    private int getAverageAmbulance(List<ResourcesHospital> list) {
        int item = 0;
        for (ResourcesHospital resources : list) {
            item += resources.getAmbulance();
        }
        var sizeHospital = list.size();
        return item / sizeHospital;
    }

    private int getAverageDoctor(List<ResourcesHospital> list) {
        int item = 0;
        for (ResourcesHospital resources : list) {
            item += resources.getDoctor();
        }
        var sizeHospital = list.size();
        return item / sizeHospital;
    }

    private int getAverageRespirator(List<ResourcesHospital> list) {
        int item = 0;
        for (ResourcesHospital resources : list) {
            item += resources.getRespirator();
        }
        var sizeHospital = list.size();
        return +item / sizeHospital;
    }

    private int getAverageTomography(List<ResourcesHospital> list) {
        int item = 0;
        for (ResourcesHospital resources : list) {
            item += resources.getTomography();
        }
        var sizeHospital = list.size();
        return item / sizeHospital;
    }

    private int getAverageNurse(List<ResourcesHospital> list) {
        int item = 0;
        for (ResourcesHospital resources : list) {
            item += resources.getNurse();
        }
        var sizeHospital = list.size();
        return item / sizeHospital;
    }
}
