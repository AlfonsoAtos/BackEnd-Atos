package com.backend.webproject.controller;

import com.backend.webproject.jtemp.Coupons;
import com.backend.webproject.jtemp.Events;
import com.backend.webproject.jtemp.JdbcTemplateCoupons;
import com.backend.webproject.jtemp.JdbcTemplateEvents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin-side")
public class AdminSideController {

    @Autowired
    JdbcTemplateCoupons jdbcTemplateCoupons;

    @Autowired
    JdbcTemplateEvents jdbcTemplateEvents;

    @RequestMapping("/")
    public String showAdminPage() {
        return "admin";
    }

    @RequestMapping("/coupons")
    public String showCouponsPage(Model model) {
        List<Coupons> newCoupons = jdbcTemplateCoupons.getNewCoupons();
        model.addAttribute("newCoupons", newCoupons);
        return "coupons";
    }

    /* GET Events */
    @RequestMapping("/events")
    public String showEventsPage(Model model) {

        try {
            List<Events> newEvents = jdbcTemplateEvents.getNewEvents();
            model.addAttribute("newEvents", newEvents);
            return "events";
        } catch (Exception e) {
            System.out.println("Can not get the items");
        }
        return "events";
    }

    /* POST Events */
    @RequestMapping("insertEvent")
    public String insertNewEvents(HttpServletRequest request) {

        try {
            int eventsId = jdbcTemplateEvents.getAutoEventsId();
            String eventsName = request.getParameter("eventsName");
            String eventsDescription = request.getParameter("eventsDescription");
            String eventsStartDate = request.getParameter("eventsStartDate");
            String eventsEndDate = request.getParameter("eventsEndDate");
            String eventsStatus = request.getParameter("eventsStatus");
            int eventsAdminId = Integer.parseInt(request.getParameter("eventsAdminId"));

            jdbcTemplateEvents.insertNewEvents(eventsId, eventsName, eventsDescription, eventsStartDate, eventsEndDate,
                    eventsStatus, eventsAdminId);

            return "redirect:/admin-side/events";
        } catch (Exception e) {
            System.out.println("Can not insert the item");
        }
        return "redirect:/admin-side/events";
    }

    /* PUT By ID */
    @RequestMapping("updateEvents/{eventsId}")
    public String updateEventsService(@PathVariable int eventsId, Model model) {

        try {
            Events eventsData = jdbcTemplateEvents.searchEventsById(eventsId);
            model.addAttribute("eventsData", eventsData);
            return "updateEventsData";
        } catch (Exception e) {
            System.out.println("Can not get item data");
        }
        return "updateEventsData";
    }

    /* PUT Events */
    @RequestMapping("updateEventsData/{eventsId}")
    public String updateEvents(HttpServletRequest request, @PathVariable int eventsId) {

        try {
            String eventsName = request.getParameter("eventsName");
            String eventsDescription = request.getParameter("eventsDescription");
            String eventsStartDate = request.getParameter("eventsStartDate");
            String eventsEndDate = request.getParameter("eventsEndDate");
            String eventsStatus = request.getParameter("eventsStatus");
            int eventsAdminId = Integer.parseInt(request.getParameter("eventsAdminId"));

            jdbcTemplateEvents.updateEvents(eventsId, eventsName, eventsDescription, eventsStartDate, eventsEndDate,
                    eventsStatus, eventsAdminId);

            return "redirect:/admin-side/events";
        } catch (Exception e) {
            System.out.println("Can not update the item data");
        }
        return "redirect:/admin-side/events";
    }

    /* DELETE Events */
    @RequestMapping("/events/deleteEvents/{eventsId}")
    public String deleteEvents(@PathVariable int eventsId) {

        try {
            jdbcTemplateEvents.deleteEvents(eventsId);
            return "redirect:/admin-side/events";
        } catch (Exception e) {
            System.out.println("Can not delete the item");
        }
        return "redirect:/admin-side/events";
    }
}
