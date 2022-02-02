package com.backend.webproject.managers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.backend.webproject.dao.CouponsDAO;
import com.backend.webproject.dao.EventsDAO;
import com.backend.webproject.entity.Coupons;
import com.backend.webproject.entity.Events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class AdminSideManager {

    @Autowired
    CouponsDAO couponsDAO;

    @Autowired
    EventsDAO eventsDAO;

    // Shows all couponsjose
    public String showCouponsPage(Model model) {
        try {
            List<Coupons> newCoupons = couponsDAO.getNewCoupons();
            model.addAttribute("newCoupons", newCoupons);

            List<Events> newEvents = eventsDAO.getNewEvents();
            model.addAttribute("newEvents", newEvents);
        } catch (Exception e) {
            System.out.println("Can not get the coupon list, reason: '" + e + "'");
        }
        return "coupons";
    }

    public Coupons searchByCartID(
            @PathVariable("couponCode") String couponCode) {
        Coupons coupon = couponsDAO.validateCoupons(couponCode);
        return coupon;
    }

    // Insert new Coupon
    public String insertNewCouponForm(HttpServletRequest request) {
        try {
            int couponId = couponsDAO.getAutoCouponId();
            String couponName = request.getParameter("couponName");
            String couponCode = request.getParameter("couponCode");
            String couponType = request.getParameter("couponType");
            int couponDiscount = Integer.parseInt(request.getParameter("couponDiscount"));
            int promotionEventId = Integer.parseInt(request.getParameter("promotionEventId"));
            int productCategoryId = Integer.parseInt(request.getParameter("productCategoryId"));

            couponsDAO.insertNewCoupon(couponId, couponName, couponCode, couponType, couponDiscount,
                    promotionEventId,
                    productCategoryId);
        } catch (Exception e) {
            System.out.println("Can not insert the coupon, reason: '" + e + "'");
        }
        return "redirect:/admin-side/coupons";
    }

    // Edit Coupon
    public String updateCoupon(@PathVariable int couponId, Model model) {
        try {
            Coupons couponData = couponsDAO.searchCouponByID(couponId);
            model.addAttribute("couponData", couponData);

            List<Events> newEvents = eventsDAO.getNewEvents();
            model.addAttribute("newEvents", newEvents);
        } catch (Exception e) {
            System.out.println("Can not get coupon data, reason: '" + e + "'");
        }
        return "updateCouponDataForm";
    }

    public String updateCoupon(HttpServletRequest request, @PathVariable int couponId) {

        try {
            String couponName = request.getParameter("couponName");
            String couponCode = request.getParameter("couponCode");
            String couponType = request.getParameter("couponType");
            int couponDiscount = Integer.parseInt(request.getParameter("couponDiscount"));
            int promotionEventId = Integer.parseInt(request.getParameter("promotionEventId"));
            int productCategoryId = Integer.parseInt(request.getParameter("productCategoryId"));

            couponsDAO.updateCoupon(couponId, couponName, couponCode, couponType, couponDiscount,
                    promotionEventId,
                    productCategoryId);

        } catch (Exception e) {
            System.out.println("Can not update the coupon data, reason: '" + e + "'");
        }

        return "redirect:/admin-side/coupons";
    }

    // Delete coupons
    public String deleteCoupon(@PathVariable(name = "couponId") int couponId) {

        try {
            couponsDAO.deleteCoupon(couponId);
        } catch (Exception e) {
            System.out.println("Can not delete the coupon, reason: '" + e + "'");
        }

        return "redirect:/admin-side/coupons";
    }

    /* -------------------------------------------------------------------- */

    /* GET Events */
    public String showEventsPage(Model model) {

        try {
            List<Events> newEvents = eventsDAO.getNewEvents();
            model.addAttribute("newEvents", newEvents);
        } catch (Exception e) {
            System.out.println("Can not get the event list, reason: '" + e + "'");
        }
        return "events";
    }

    /* POST Events */
    public String insertNewEvents(HttpServletRequest request) {

        try {
            int eventsId = eventsDAO.getAutoEventsId();
            String eventsName = request.getParameter("eventsName");
            String eventsDescription = request.getParameter("eventsDescription");
            String eventsStartDate = request.getParameter("eventsStartDate");
            String eventsEndDate = request.getParameter("eventsEndDate");
            String eventsStatus = request.getParameter("eventsStatus");
            int eventsAdminId = Integer.parseInt(request.getParameter("eventsAdminId"));

            eventsDAO.insertNewEvents(eventsId, eventsName, eventsDescription, eventsStartDate, eventsEndDate,
                    eventsStatus, eventsAdminId);
        } catch (Exception e) {
            System.out.println("Can not insert the event, reason: '" + e + "'");
        }
        return "redirect:/admin-side/events";
    }

    /* PUT By ID */
    public String updateEventsService(@PathVariable int eventsId, Model model) {

        try {
            Events eventsData = eventsDAO.searchEventsById(eventsId);
            model.addAttribute("eventsData", eventsData);
        } catch (Exception e) {
            System.out.println("Can not get event data, reason: '" + e + "'");
        }
        return "updateEventsData";
    }

    /* PUT Events */
    public String updateEvents(HttpServletRequest request, @PathVariable int eventsId) {

        try {
            String eventsName = request.getParameter("eventsName");
            String eventsDescription = request.getParameter("eventsDescription");
            String eventsStartDate = request.getParameter("eventsStartDate");
            String eventsEndDate = request.getParameter("eventsEndDate");
            String eventsStatus = request.getParameter("eventsStatus");
            int eventsAdminId = Integer.parseInt(request.getParameter("eventsAdminId"));

            eventsDAO.updateEvents(eventsId, eventsName, eventsDescription, eventsStartDate, eventsEndDate,
                    eventsStatus, eventsAdminId);
        } catch (Exception e) {
            System.out.println("Can not update the event data, reason: '" + e + "'");
        }
        return "redirect:/admin-side/events";
    }

    /* DELETE Events */
    public String deleteEvents(@PathVariable int eventsId) {

        try {
            eventsDAO.deleteEvents(eventsId);
        } catch (Exception e) {
            System.out.println("Can not delete the event, reason: '" + e + "'");
        }
        return "redirect:/admin-side/events";
    }
}
