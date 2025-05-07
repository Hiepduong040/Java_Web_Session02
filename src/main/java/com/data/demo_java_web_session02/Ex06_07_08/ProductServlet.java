package com.data.demo_java_web_session02.Ex06_07_08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private List<Product> productList = new ArrayList<>();
    private int nextId = 1;

    public ProductServlet() {
        super();
        productList.add(new Product(nextId++, "Chuột gaming", 39000000));
        productList.add(new Product(nextId++, "Ipad ", 19000000));
        productList.add(new Product(nextId++, "Laptop Dell ", 5900000));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            for (Product product : productList) {
                if (product.getId() == id) {
                    request.setAttribute("product", product);
                    request.getRequestDispatcher("editProduct.jsp").forward(request, response);
                    return;
                }
            }
            response.sendRedirect("products");
        } else {
            request.setAttribute("products", productList);
            request.getRequestDispatcher("productList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            productList.removeIf(p -> p.getId() == id);
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));

            for (Product product : productList) {
                if (product.getId() == id) {
                    product.setName(name);
                    product.setPrice(price);
                    break;
                }
            }
        } else {
            String name = request.getParameter("name");
            double price = 0;
            try {
                price = Double.parseDouble(request.getParameter("price"));
            } catch (NumberFormatException e) {
            }
            if (name != null && !name.trim().isEmpty() && price > 0) {
                Product newProduct = new Product(nextId++, name, price);
                productList.add(newProduct);
            }
        }

        response.sendRedirect(request.getContextPath() + "/products");
    }

    private Product findById(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    private void updateProduct(int id, String name, double price) {
        Product product = findById(id);
        if (product != null) {
            product.setName(name);
            product.setPrice(price);
        }
    }

    private void deleteById(int id) {
        productList.removeIf(p -> p.getId() == id);
    }
}