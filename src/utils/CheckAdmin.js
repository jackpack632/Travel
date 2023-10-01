export function checkAdminRole() {
    const token = localStorage.getItem('token');
    if (!token) {
        // 如果没有提供 Token，则返回 false
        return false;
    }

    try {
        // 提取载荷部分
        const payloadBase64 = token.split('.')[1];

        // 解码 Base64
        const decodedPayload = atob(payloadBase64);

        // 将 JSON 字符串转换为 JavaScript 对象
        const payloadObject = JSON.parse(decodedPayload);

        // 检查 role 是否为 'admin'
        return payloadObject.role === 'admin';
    } catch (error) {
        // 如果解析出现错误，返回 false
        return false;
    }
}