package view;

import model.ManagerProduct;
import model.Product;
import validate.Validate;

import java.util.Scanner;

public class MenuProduct {
    ManagerProduct managerProduct = new ManagerProduct();
    Scanner inputNumber = new Scanner(System.in);
    Scanner inputStr = new Scanner(System.in);

    public void MenuUser() {
        boolean run = true;
        while (run) {
            System.out.println("===== Cửa Hàng Thức Ăn Cho Trym ====");
            System.out.println("1: Thêm Sản Phẩm");
            System.out.println("2: Sửa Sản Phẩm");
            System.out.println("3: Xóa Sản Phẩm");
            System.out.println("4: Danh Sách Sản Phẩm");
            System.out.println("5: Tìm Sản Phẩm Theo ID");
            System.out.println("6: Tìm Sản Phẩm Theo Tên Gần Đúng");
            System.out.println("7: Tìm Sản Phẩm Theo Loại Sản Phẩm");
            System.out.println("0: Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = Validate.checkChoice();
            switch (choice) {
                case 1:
                    formAddProduct();
                    break;
                case 2:
                    Edit();
                    break;
                case 3:
                    formDelete();
                    break;
                case 4:
                    getAllProduct();
                    break;
                case 5:
                    FindProductByID();
                    break;
                case 6:
                    FindProductByName();
                    break;
                case 7:
                    FindProductByTypeProduct();
                    break;
                default:
                    run = false;
            }
        }
    }

    public void formAddProduct() {
        System.out.println("==== Thêm Sản Phẩm Mới ====");
        System.out.println("Nhập vào Mã Sản Phẩm - Ví Du: HD1");
        String ID = Validate.checkID();
        System.out.println("Nhập vào Tên Sản Phẩm -  Ví Dụ: Hàu Sữa");
        String name = Validate.checkName();
        System.out.println("Nhập vào Số Lượng Sản Phẩm - Ví Dụ: 10");
        int quantity = Validate.checkSoL();
        System.out.println("Nhập vào Giá Sản Phẩm - Ví Dụ: 300");
        int price = Validate.Price();
        System.out.println("Nhập vào Loại Sản Phẩm - Ví Dụ: L1");
        String type = inputStr.nextLine();
        Product product = new Product(ID, name, quantity, price, type);
        managerProduct.add(product);
        System.out.println("Thêm Thành Công!");
    }

    public void Edit() {
        System.out.println("=== Sửa Sản Phẩm ===");
        System.out.println("Nhập vào Mã Sản Phẩm Muốn Sửa - Ví Dụ: HD1");
        String ID = Validate.checkID();
        if (managerProduct.findIndex(ID) != -1) {
            System.out.println("Nhập vào Mã Sản Phẩm - Ví Du: HD1");
            String id = Validate.checkID();
            System.out.println("Nhập vào Tên Sản Phẩm -  Ví Dụ: Hàu Sữa");
            String name = Validate.checkName();
            System.out.println("Nhập vào Số Lượng Sản Phẩm - Ví Dụ: 10");
            int quantity = Validate.checkSoL();
            System.out.println("Nhập vào Giá Sản Phẩm - Ví Dụ: 300");
            int price = Validate.Price();
            System.out.println("Nhập vào Loại Sản Phẩm - Ví Dụ: L1");
            String type = inputStr.nextLine();
            managerProduct.edit(ID, new Product(id, name, quantity, price, type));
            System.out.println("Sửa Thành Công");
        } else {
            System.out.println("Không Tìm Thấy Mã Sản Phẩm Muốn Sửa!");
        }
    }

    public void formDelete() {
        System.out.println("===Xóa Sản Phẩm===");
        System.out.println("Nhập vào Mã Sản Phẩm Muốn Xóa - Ví Dụ: HD1");
        String id = inputStr.nextLine();
        if (managerProduct.findIndex(id) != -1) {
            managerProduct.delete(id);
            System.out.println("Xóa Thành Công!");
        } else {
            System.out.println("Không Tìm Thấy Mã Phòng Muốn Xóa!");
        }
    }

    public void getAllProduct() {
        System.out.println("=== Danh Sách Sản Phẩm ===");
        for (Product product : managerProduct.getAllProduct()) {
            System.out.println(product);
        }
    }

    public void FindProductByID() {
        System.out.println("Nhập vào Mã Sản Phẩm Muốn Tìm - Ví Du: HD1 ");
        String ID = Validate.checkID();
        System.out.println("=== Danh Sách Sản Phẩm Theo Mã===");
        for (Product product : managerProduct.findProductById(ID)) {
            System.out.println(product);
        }
    }

    public void FindProductByName() {
        System.out.println("Nhập vào tên Sản Phẩm Gần Đúng - Ví Du: H");
        String name = inputStr.nextLine();
        System.out.println("=== Danh Sách Sản Phẩm Theo Tên Gần Đúng ===");
        for (Product product : managerProduct.findProductByName(name)) {
            System.out.println(product);
        }
    }

    public void FindProductByTypeProduct() {
        System.out.println("Nhập vào Loại Muốn Tìm - Ví Du: L1");
        String type = inputStr.nextLine();
        System.out.println("=== Danh Sách Sản Phẩm Theo Loại ===");
        for (Product product : managerProduct.findProductByProductType(type)) {
            System.out.println(product);
        }
    }
}
