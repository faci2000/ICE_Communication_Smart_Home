//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.7
//
// <auto-generated>
//
// Generated from file `smartHome.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package smartHome;

public interface INetworkMonitorPrx extends ISmartHomeDevicePrx
{
    default NetworkStatus changeNetworkStatus(NetworkStatus newNetworkStatus)
    {
        return changeNetworkStatus(newNetworkStatus, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default NetworkStatus changeNetworkStatus(NetworkStatus newNetworkStatus, java.util.Map<String, String> context)
    {
        return _iceI_changeNetworkStatusAsync(newNetworkStatus, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<NetworkStatus> changeNetworkStatusAsync(NetworkStatus newNetworkStatus)
    {
        return _iceI_changeNetworkStatusAsync(newNetworkStatus, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<NetworkStatus> changeNetworkStatusAsync(NetworkStatus newNetworkStatus, java.util.Map<String, String> context)
    {
        return _iceI_changeNetworkStatusAsync(newNetworkStatus, context, false);
    }

    /**
     * @hidden
     * @param iceP_newNetworkStatus -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<NetworkStatus> _iceI_changeNetworkStatusAsync(NetworkStatus iceP_newNetworkStatus, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<NetworkStatus> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "changeNetworkStatus", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     NetworkStatus.ice_write(ostr, iceP_newNetworkStatus);
                 }, istr -> {
                     NetworkStatus ret;
                     ret = NetworkStatus.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    default boolean registerNewIpv6Device(Ipv6Address device)
        throws OperationNotSupportedException
    {
        return registerNewIpv6Device(device, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default boolean registerNewIpv6Device(Ipv6Address device, java.util.Map<String, String> context)
        throws OperationNotSupportedException
    {
        try
        {
            return _iceI_registerNewIpv6DeviceAsync(device, context, true).waitForResponseOrUserEx();
        }
        catch(OperationNotSupportedException ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> registerNewIpv6DeviceAsync(Ipv6Address device)
    {
        return _iceI_registerNewIpv6DeviceAsync(device, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> registerNewIpv6DeviceAsync(Ipv6Address device, java.util.Map<String, String> context)
    {
        return _iceI_registerNewIpv6DeviceAsync(device, context, false);
    }

    /**
     * @hidden
     * @param iceP_device -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> _iceI_registerNewIpv6DeviceAsync(Ipv6Address iceP_device, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "registerNewIpv6Device", null, sync, _iceE_registerNewIpv6Device);
        f.invoke(true, context, null, ostr -> {
                     Ipv6Address.ice_write(ostr, iceP_device);
                 }, istr -> {
                     boolean ret;
                     ret = istr.readBool();
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_registerNewIpv6Device =
    {
        OperationNotSupportedException.class
    };

    default boolean registerNewIpv4Device(IpAddress device)
        throws OperationNotSupportedException
    {
        return registerNewIpv4Device(device, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default boolean registerNewIpv4Device(IpAddress device, java.util.Map<String, String> context)
        throws OperationNotSupportedException
    {
        try
        {
            return _iceI_registerNewIpv4DeviceAsync(device, context, true).waitForResponseOrUserEx();
        }
        catch(OperationNotSupportedException ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> registerNewIpv4DeviceAsync(IpAddress device)
    {
        return _iceI_registerNewIpv4DeviceAsync(device, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> registerNewIpv4DeviceAsync(IpAddress device, java.util.Map<String, String> context)
    {
        return _iceI_registerNewIpv4DeviceAsync(device, context, false);
    }

    /**
     * @hidden
     * @param iceP_device -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> _iceI_registerNewIpv4DeviceAsync(IpAddress iceP_device, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "registerNewIpv4Device", null, sync, _iceE_registerNewIpv4Device);
        f.invoke(true, context, null, ostr -> {
                     IpAddress.ice_write(ostr, iceP_device);
                 }, istr -> {
                     boolean ret;
                     ret = istr.readBool();
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_registerNewIpv4Device =
    {
        OperationNotSupportedException.class
    };

    default boolean removeIpv6Device(Ipv6Address device)
        throws DeviceNotExistsException,
               OperationNotSupportedException
    {
        return removeIpv6Device(device, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default boolean removeIpv6Device(Ipv6Address device, java.util.Map<String, String> context)
        throws DeviceNotExistsException,
               OperationNotSupportedException
    {
        try
        {
            return _iceI_removeIpv6DeviceAsync(device, context, true).waitForResponseOrUserEx();
        }
        catch(DeviceNotExistsException ex)
        {
            throw ex;
        }
        catch(OperationNotSupportedException ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> removeIpv6DeviceAsync(Ipv6Address device)
    {
        return _iceI_removeIpv6DeviceAsync(device, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> removeIpv6DeviceAsync(Ipv6Address device, java.util.Map<String, String> context)
    {
        return _iceI_removeIpv6DeviceAsync(device, context, false);
    }

    /**
     * @hidden
     * @param iceP_device -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> _iceI_removeIpv6DeviceAsync(Ipv6Address iceP_device, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "removeIpv6Device", null, sync, _iceE_removeIpv6Device);
        f.invoke(true, context, null, ostr -> {
                     Ipv6Address.ice_write(ostr, iceP_device);
                 }, istr -> {
                     boolean ret;
                     ret = istr.readBool();
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_removeIpv6Device =
    {
        DeviceNotExistsException.class,
        OperationNotSupportedException.class
    };

    default boolean removeIpv4Device(IpAddress device)
        throws DeviceNotExistsException,
               OperationNotSupportedException
    {
        return removeIpv4Device(device, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default boolean removeIpv4Device(IpAddress device, java.util.Map<String, String> context)
        throws DeviceNotExistsException,
               OperationNotSupportedException
    {
        try
        {
            return _iceI_removeIpv4DeviceAsync(device, context, true).waitForResponseOrUserEx();
        }
        catch(DeviceNotExistsException ex)
        {
            throw ex;
        }
        catch(OperationNotSupportedException ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> removeIpv4DeviceAsync(IpAddress device)
    {
        return _iceI_removeIpv4DeviceAsync(device, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> removeIpv4DeviceAsync(IpAddress device, java.util.Map<String, String> context)
    {
        return _iceI_removeIpv4DeviceAsync(device, context, false);
    }

    /**
     * @hidden
     * @param iceP_device -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> _iceI_removeIpv4DeviceAsync(IpAddress iceP_device, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "removeIpv4Device", null, sync, _iceE_removeIpv4Device);
        f.invoke(true, context, null, ostr -> {
                     IpAddress.ice_write(ostr, iceP_device);
                 }, istr -> {
                     boolean ret;
                     ret = istr.readBool();
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_removeIpv4Device =
    {
        DeviceNotExistsException.class,
        OperationNotSupportedException.class
    };

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static INetworkMonitorPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), INetworkMonitorPrx.class, _INetworkMonitorPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static INetworkMonitorPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), INetworkMonitorPrx.class, _INetworkMonitorPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static INetworkMonitorPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), INetworkMonitorPrx.class, _INetworkMonitorPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static INetworkMonitorPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), INetworkMonitorPrx.class, _INetworkMonitorPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static INetworkMonitorPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, INetworkMonitorPrx.class, _INetworkMonitorPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static INetworkMonitorPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, INetworkMonitorPrx.class, _INetworkMonitorPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default INetworkMonitorPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (INetworkMonitorPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default INetworkMonitorPrx ice_adapterId(String newAdapterId)
    {
        return (INetworkMonitorPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default INetworkMonitorPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (INetworkMonitorPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default INetworkMonitorPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (INetworkMonitorPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default INetworkMonitorPrx ice_invocationTimeout(int newTimeout)
    {
        return (INetworkMonitorPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default INetworkMonitorPrx ice_connectionCached(boolean newCache)
    {
        return (INetworkMonitorPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default INetworkMonitorPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (INetworkMonitorPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default INetworkMonitorPrx ice_secure(boolean b)
    {
        return (INetworkMonitorPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default INetworkMonitorPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (INetworkMonitorPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default INetworkMonitorPrx ice_preferSecure(boolean b)
    {
        return (INetworkMonitorPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default INetworkMonitorPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (INetworkMonitorPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default INetworkMonitorPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (INetworkMonitorPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default INetworkMonitorPrx ice_collocationOptimized(boolean b)
    {
        return (INetworkMonitorPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default INetworkMonitorPrx ice_twoway()
    {
        return (INetworkMonitorPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default INetworkMonitorPrx ice_oneway()
    {
        return (INetworkMonitorPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default INetworkMonitorPrx ice_batchOneway()
    {
        return (INetworkMonitorPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default INetworkMonitorPrx ice_datagram()
    {
        return (INetworkMonitorPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default INetworkMonitorPrx ice_batchDatagram()
    {
        return (INetworkMonitorPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default INetworkMonitorPrx ice_compress(boolean co)
    {
        return (INetworkMonitorPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default INetworkMonitorPrx ice_timeout(int t)
    {
        return (INetworkMonitorPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default INetworkMonitorPrx ice_connectionId(String connectionId)
    {
        return (INetworkMonitorPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default INetworkMonitorPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (INetworkMonitorPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::smartHome::INetworkMonitor";
    }
}
