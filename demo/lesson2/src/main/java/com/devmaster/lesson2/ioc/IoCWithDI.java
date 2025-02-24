package com.devmaster.lesson2.ioc;


// Dịch vụ (Service) cung cấp chức năng serve()
class IoCService {
    public void serve() {
        System.out.println("Service is serving");
    }
}

// Lớp Client sử dụng Service nhưng không tự tạo Service, mà nhận từ bên ngoài
class IoCClient {
    private IoCService iocService;

    // Dùng Dependency Injection để truyền service vào thay vì tự tạo nó
    public IoCClient(IoCService service) {
        this.iocService = service;
    }

    public void doSomething() {
        iocService.serve();
    }
}

// Chương trình chính sử dụng Dependency Injection
public class IoCWithDI {
    public static void main(String[] args) {
        // Tạo đối tượng Service
        IoCService service = new IoCService();

        // Inject Service vào Client
        IoCClient client = new IoCClient(service);

        // Gọi phương thức doSomething() để sử dụng Service
        client.doSomething();
    }
}