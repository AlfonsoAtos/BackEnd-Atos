package com.backend.webproject.controller;

import com.backend.webproject.jtemp.Coupons;
import com.backend.webproject.jtemp.JdbcTemplateCoupons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin-side")
public class AdminSideController {

    @Autowired
    JdbcTemplateCoupons jdbcTemplateCoupons;

    @RequestMapping("/")
    public String showAdminPage() {
        return "admin";
    }

    // Shows all couponsjose
    @RequestMapping("/coupons")
    public String showCouponsPage(Model model) {
        try {
            List<Coupons> newCoupons = jdbcTemplateCoupons.getNewCoupons();
            model.addAttribute("newCoupons", newCoupons);
            return "coupons";
        } catch (Exception e) {
            System.out.println("Couldn't reach your request");
        }
        return "coupons";
    }

    // Insert new Coupon
    @RequestMapping("insertCoupon")
    public String insertNewCouponForm(HttpServletRequest request) {
        try {
            int couponId = jdbcTemplateCoupons.getAutoCouponId();
            String couponName = request.getParameter("couponName");
            String couponCode = request.getParameter("couponCode");
            String couponType = request.getParameter("couponType");
            int couponDiscount = Integer.parseInt(request.getParameter("couponDiscount"));
            int promotionEventId = Integer.parseInt(request.getParameter("promotionEventId"));
            int productCategoryId = Integer.parseInt(request.getParameter("productCategoryId"));

            jdbcTemplateCoupons.insertNewCoupon(couponId, couponName, couponCode, couponType, couponDiscount,
                    promotionEventId,
                    productCategoryId);

            return "redirect:/admin-side/coupons";
        } catch (Exception e) {
            System.out.println("Couldn't reach your request");
        }
        return "redirect:/admin-side/coupons";
    }

    // Edit Coupon
    @RequestMapping("updateCoupon/{couponId}")
    public String updateCoupon(@PathVariable int couponId, Model model) {
        try {
            Coupons couponData = jdbcTemplateCoupons.searchCouponByID(couponId);
            model.addAttribute("couponData", couponData);
            return "updateCouponDataForm";
        } catch (Exception e) {
            System.out.println("Couldn't reach your request");
        }
        return "updateCouponDataForm";
    }

    @RequestMapping("updateCouponData/{couponId}")
    public String updateCoupon(HttpServletRequest request, @PathVariable int couponId) {

        try {
            String couponName = request.getParameter("couponName");
            String couponCode = request.getParameter("couponCode");
            String couponType = request.getParameter("couponType");
            int couponDiscount = Integer.parseInt(request.getParameter("couponDiscount"));
            int promotionEventId = Integer.parseInt(request.getParameter("promotionEventId"));
            int productCategoryId = Integer.parseInt(request.getParameter("productCategoryId"));

            jdbcTemplateCoupons.updateCoupon(couponId, couponName, couponCode, couponType, couponDiscount,
                    promotionEventId,
                    productCategoryId);

            return "redirect:/admin-side/coupons";

        } catch (Exception e) {
            System.out.println("Couldn't reach your request");
        }

        return "redirect:/admin-side/coupons";
    }

    // Delete coupons
    @RequestMapping("/deleteCoupon/{couponId}")
    public String deleteCoupon(@PathVariable(name = "couponId") int couponId) {

        try {
            jdbcTemplateCoupons.deleteCoupon(couponId);
            return "redirect:/admin-side/coupons";
        } catch (Exception e) {
            System.out.println("Couldn't delete the item");
        }

        return "redirect:/admin-side/coupons";
    }
}
