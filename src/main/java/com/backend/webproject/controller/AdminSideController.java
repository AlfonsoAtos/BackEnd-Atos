package com.backend.webproject.controller;

import com.backend.webproject.entity.Coupons;
import com.backend.webproject.managers.AdminSideManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin-side")
public class AdminSideController {

    @Autowired
    AdminSideManager adminSideManager;

    @RequestMapping("/")
    public String showAdminPage() {

        return "admin";
    }

    // Shows all couponsjose
    @RequestMapping("/coupons")
    public String showCouponsPage(Model model) {
        return adminSideManager.showCouponsPage(model);
    }

    @RequestMapping("/validateCoupon/{couponCode}")
    @ResponseBody
    public Coupons searchByCartID(
            @PathVariable("couponCode") String couponCode) {

        return adminSideManager.searchByCartID(couponCode);
    }

    // Insert new Coupon
    @RequestMapping("insertCoupon")
    public String insertNewCouponForm(HttpServletRequest request) {
        return adminSideManager.insertNewCouponForm(request);
    }

    // Edit Coupon
    @RequestMapping("updateCoupon/{couponId}")
    public String updateCoupon(@PathVariable int couponId, Model model) {
        return adminSideManager.updateCoupon(couponId, model);
    }

    @RequestMapping("updateCouponData/{couponId}")
    public String updateCoupon(HttpServletRequest request, @PathVariable int couponId) {
        return adminSideManager.updateCoupon(request, couponId);
    }

    // Delete coupons
    @RequestMapping("/deleteCoupon/{couponId}")
    public String deleteCoupon(@PathVariable(name = "couponId") int couponId) {
        return adminSideManager.deleteCoupon(couponId);
    }

    /* -------------------------------------------------------------------- */

    /* GET Events */
    @RequestMapping("/events")
    public String showEventsPage(Model model) {
        return adminSideManager.showEventsPage(model);
    }

    /* POST Events */
    @RequestMapping("insertEvent")
    public String insertNewEvents(HttpServletRequest request) {
        return adminSideManager.insertNewEvents(request);
    }

    /* PUT By ID */
    @RequestMapping("updateEvents/{eventsId}")
    public String updateEventsService(@PathVariable int eventsId, Model model) {
        return adminSideManager.updateEventsService(eventsId, model);
    }

    /* PUT Events */
    @RequestMapping("updateEventsData/{eventsId}")
    public String updateEvents(HttpServletRequest request, @PathVariable int eventsId) {
        return adminSideManager.updateEvents(request, eventsId);
    }

    /* DELETE Events */
    @RequestMapping("/events/deleteEvents/{eventsId}")
    public String deleteEvents(@PathVariable int eventsId) {
        return adminSideManager.deleteEvents(eventsId);
    }

    /*----------------------------------------------------------------------*/

    // Get all the products
    @RequestMapping("/products")
    public String showProductsPage(Model model) {
        return adminSideManager.showProductsPage(model);
    }

    // Insert a new product
    @RequestMapping("insertProduct")
    public String insertNewProductForm(HttpServletRequest request) {
        return adminSideManager.insertNewProductForm(request);
    }

    // Update a product
    @RequestMapping("updateProduct/{pID}")
    public String updateProduct(@PathVariable(name = "pID") int pID, Model model) {
        return adminSideManager.updateProduct(pID, model);
    }

    @RequestMapping("updateProductData/{pID}")
    public String updateProduct(HttpServletRequest request, @PathVariable(name = "pID") int pID) {
        return adminSideManager.updateProduct(request, pID);
    }

    // Delete a product
    @RequestMapping("/deleteProduct/{pID}")
    public String deleteProduct(@PathVariable(name = "pID") int pID) {
        return adminSideManager.deleteProduct(pID);
    }

}
