package com.backend.webproject.managers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.backend.webproject.dao.CouponsDAO;
import com.backend.webproject.dao.EventsDAO;
import com.backend.webproject.dao.ProductDAO;
import com.backend.webproject.entity.Coupons;
import com.backend.webproject.entity.Events;
import com.backend.webproject.entity.Product;

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

    @Autowired
    ProductDAO productDAO;

    // Shows all couponsjose
    public String showCouponsPage(Model model) {
        try {
            List<Coupons> newCouponsTable = couponsDAO.getNewCoupons();
            model.addAttribute("newCouponsTable", newCouponsTable);

            List<Events> newEvents = eventsDAO.getNewEvents();
            model.addAttribute("newEvents", newEvents);

            List<Coupons> newCoupons = couponsDAO.getNewCouponsJoined();
            model.addAttribute("newCoupons", newCoupons);
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

    //-----------------------------------------------------------------------------------------------------------------------------

    // Get all the products
    public String showProductsPage(Model model) {
        try {
            List<Product> allProducts = productDAO.getNewCouponsJoined();
            model.addAttribute("allProducts", allProducts);
        } catch (Exception e) {
            System.out.println("Can not get the product list, reason: '" + e + "'");
        }
        return "productsAdmin";
    }

    // Insert a new product
    public String insertNewProductForm(HttpServletRequest request) {
        try {
            int pID = productDAO.getAutoProductId();
            String pName = request.getParameter("pName");
            String pCompany = request.getParameter("pCompany");
            float pPrice = Float.parseFloat(request.getParameter("pPrice"));
            String pDescription = request.getParameter("pDescription");
            String pImagePath = request.getParameter("pImagePath");
            int pCategoryId = Integer.parseInt(request.getParameter("pCategoryId"));

            productDAO.insertNewProduct(pID, pName, pCompany, pPrice, pDescription, pImagePath, pCategoryId);
        } catch (Exception e) {
            System.out.println("Can not insert the product, reason: '" + e + "'");
        }
        return "redirect:/admin-side/products";
    }

    // Update a product
    public String updateProduct(int pID, Model model) {
        try {
            Product productData = productDAO.getProductById(pID);
            model.addAttribute("productData", productData);
        } catch (Exception e) {
            System.out.println("Can not get product data, reason: '" + e + "'");
        }
        return "updateProductDataForm";
    }

    public String updateProduct(HttpServletRequest request, int pID) {

        try {
            String pName = request.getParameter("pName");
            String pCompany = request.getParameter("pCompany");
            float pPrice = Float.parseFloat(request.getParameter("pPrice"));
            String pDescription = request.getParameter("pDescription");
            String pImagePath = request.getParameter("pImagePath");
            int pCategoryID = Integer.parseInt(request.getParameter("pCategoryID"));

            productDAO.updateProduct(pID, pName, pCompany, pPrice, pDescription, pImagePath, pCategoryID);

        } catch (Exception e) {
            System.out.println("Can not update the product data, reason: '" + e + "'");
        }

        return "redirect:/admin-side/products";
    }

    // Delete a product
    public String deleteProduct(int pID) {

        try {
            productDAO.deleteProduct(pID);
        } catch (Exception e) {
            System.out.println("Can not delete the product, reason: '" + e + "'");
        }

        return "redirect:/admin-side/products";
    }

}
