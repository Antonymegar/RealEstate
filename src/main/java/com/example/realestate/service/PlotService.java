package com.example.realestate.service;

import com.example.realestate.Payload.PlotRequest;
import com.example.realestate.Repositories.CategoryRepo;
import com.example.realestate.Repositories.PlotRepo;
import com.example.realestate.model.Plot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.realestate.model.LandStatus.*;

@Service
public class PlotService {
    @Autowired
    private PlotRepo plotRepo;

    @Autowired
    private CategoryRepo categoryRepo;


    private static final Logger logger = LoggerFactory.getLogger(PlotService.class);

    public Plot createPlot(PlotRequest plotRequest){
        Plot plot = new Plot();
        plot.setPlotsize(plotRequest.getPlotsize());
        plot.setPrice(plotRequest.getPrice());
        plot.setCurrency(plotRequest.getCurrency());
        plot.setPlotNumber(plotRequest.getPlotNumber());
        plot.setStatus(plotRequest.getStatus(BOOKED, SOLD, AVAILABLE ));

        plot.setCategory(plotRequest.getCategory(categoryRepo.findAll()));

        return plotRepo.save(plot);
    }

}
