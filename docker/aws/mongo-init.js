db.createUser(
    {
        user: "product_app",
        pwd: "pr0duc7!",
        roles: [
            {
                role: "readWrite",
                db: "product"
            }
        ]
    }
);