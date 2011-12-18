#ifndef CYGONCE_PKGCONF_HAL_H
#define CYGONCE_PKGCONF_HAL_H
/*
 * File <pkgconf/hal.h>
 *
 * This file is generated automatically by the configuration
 * system. It should not be edited. Any changes to this file
 * may be overwritten.
 */

/***** proc output start *****/
#include <pkgconf/system.h>
#include CYGBLD_HAL_TARGET_H
#ifdef   CYGBLD_HAL_VARIANT_H
#include CYGBLD_HAL_VARIANT_H
#endif
#include CYGBLD_HAL_PLATFORM_H
/****** proc output end ******/
#define CYGPKG_HAL_COMMON 1
#define CYGFUN_HAL_COMMON_KERNEL_SUPPORT 1
#define CYGPKG_HAL_EXCEPTIONS 1
#define CYGINT_HAL_SUPPORTS_MMU_TABLES 0
#define CYGINT_HAL_SUPPORTS_MMU_TABLES_0
#define CYGDBG_HAL_DIAG_TO_DEBUG_CHAN 1
#define CYGSEM_HAL_DIAG_MANGLER None
#define CYGSEM_HAL_DIAG_MANGLER_None
#define CYGPKG_HAL_COMMON_INTERRUPTS 1
#define CYGIMP_HAL_COMMON_INTERRUPTS_USE_INTERRUPT_STACK 1
#define CYGNUM_HAL_COMMON_INTERRUPTS_STACK_SIZE 4096
#define CYGNUM_HAL_COMMON_INTERRUPTS_STACK_SIZE_4096
#define CYGPKG_HAL_COMMON_CONTEXT 1
#define CYGSEM_HAL_ENABLE_DCACHE_ON_STARTUP 1
#define CYGSEM_HAL_DCACHE_STARTUP_MODE COPYBACK
#define CYGSEM_HAL_DCACHE_STARTUP_MODE_COPYBACK
#define CYGSEM_HAL_ENABLE_ICACHE_ON_STARTUP 1
#define CYGPKG_HAL_DEBUG 1
#define CYGNUM_HAL_DEBUG_GDB_PROTOCOL_RETRIES 0
#define CYGNUM_HAL_DEBUG_GDB_PROTOCOL_RETRIES_0
#define CYGNUM_HAL_DEBUG_GDB_PROTOCOL_TIMEOUT 500
#define CYGNUM_HAL_DEBUG_GDB_PROTOCOL_TIMEOUT_500
#define CYGDBG_HAL_CRCTABLE_LOCATION RAM
#define CYGDBG_HAL_CRCTABLE_LOCATION_RAM
#define CYGSEM_HAL_VIRTUAL_VECTOR_SUPPORT 1
#define CYGPRI_HAL_VIRTUAL_VECTOR_DEBUG_CHANNEL_CONFIGURABLE 1
#define CYGSEM_HAL_VIRTUAL_VECTOR_INIT_WHOLE_TABLE 1
#define CYGSEM_HAL_VIRTUAL_VECTOR_CLAIM_RESET 1
#define CYGSEM_HAL_VIRTUAL_VECTOR_CLAIM_VERSION 1
#define CYGSEM_HAL_VIRTUAL_VECTOR_CLAIM_DELAY_US 1
#define CYGSEM_HAL_VIRTUAL_VECTOR_CLAIM_CACHE 1
#define CYGSEM_HAL_VIRTUAL_VECTOR_CLAIM_DATA 1
#define CYGSEM_HAL_VIRTUAL_VECTOR_CLAIM_COMMS 1
#define CYGSEM_HAL_VIRTUAL_VECTOR_DIAG 1
#define CYGINT_HAL_PLF_IF_INIT 0
#define CYGINT_HAL_PLF_IF_INIT_0
#define CYGINT_HAL_PLF_IF_IDE 0
#define CYGINT_HAL_PLF_IF_IDE_0

#endif
