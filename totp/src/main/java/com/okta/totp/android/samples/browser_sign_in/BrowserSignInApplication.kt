class BrowserSignInApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initializes Auth Foundation and Credential Bootstrap classes.
        AuthFoundationDefaults.cache = SharedPreferencesCache.create(this)
        val oidcConfiguration = OidcConfiguration(
            clientId = BuildConfig.CLIENT_ID,
            defaultScope = "openid email profile offline_access",
        )
        val client = OidcClient.createFromDiscoveryUrl(
            oidcConfiguration,
            BuildConfig.DISCOVERY_URL.toHttpUrl(),
        )
        CredentialBootstrap.initialize(client.createCredentialDataSource(this))
    }
}