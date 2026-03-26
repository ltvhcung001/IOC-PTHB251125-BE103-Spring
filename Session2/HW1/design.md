Các endpoint:
1. Lấy toàn bộ danh sách công việc, người dùng.
- Lấy toàn bộ danh sách oông việc: GET /tasks
- Lấy toàn bộ danh sách người dùng: GET /users
2. Tạo mới công việc, tạo mới người dùng.
- Tạo mới công việc: POST /tasks
- Tạo mới người dùng: POST /users
3. Cập nhật trạng thái một công việc, cập nhật vai trò của người dùng.
- Cập nhật trạng thái một công việc: PUT /tasks/{id}
- Cập nhật vai trò của người dùng: PUT /users/{id}
4. Xoá một công việc, xoá một người dùng khỏi hệ thống.
- Xoá một công việc: DELETE /tasks/{id}
- Xoá một người dùng khỏi hệ thống: DELETE /users/{id}
5. Tìm kiếm các công việc có độ ưu tiên "high".
- Tìm kiếm các công việc có độ ưu tiên "high": GET /tasks?priority=high
6. Tìm các công việc có độ ưu tiên là "high" và được giao cho người dùng với id là 1.
- Tìm các công việc có độ ưu tiên là "high" và được giao cho người dùng với id là 1: GET /tasks?priority=high&assignedUserId=1
7. Liệt kê toàn bộ công việc của 1 người dùng.
- Liệt kê toàn bộ công việc của 1 người dùng: GET /users/{id}/tasks
8. Gắn công việc cho người dùng.
- Gắn công việc cho người dùng: POST /tasks/{taskId}/assign/{userId}