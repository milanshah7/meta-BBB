# Kernel Recipe to fetch Linux Stable Version 5.4

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

PV = "${LINUX_VERSION}+git${SRCPV}"
LINUX_VERSION ?= "5.4"
KERNEL_VERSION_SANITY_SKIP="1"

S = "${WORKDIR}/git"

# Override COMPATIBLE_MACHINE to include your machine in a copy of this recipe
# file. Leaving it empty here ensures an early explicit build failure.
COMPATIBLE_MACHINE_beaglebone-yocto = "beaglebone-yocto"

SRC_URI = " \
           git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;branch=linux-5.4.y \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.4;destsuffix=${KMETA} \
"
SRC_URI[sha256sum] = "a31d1f68fe36ef6cdb798f10cab771a9ab35546c90a61569476205d49e7e87fe"
SRCREV="${AUTOREV}"

SRC_URI += " \
    file://defconfig \
    file://smp.cfg \
    file://unset_MFD_CPCAP.cfg \
"

# bitbake.conf only prepends PARALLEL make in tasks called do_compile, which isn't the case for compile_modules
# So explicitly enable it for that in here
EXTRA_OEMAKE = "${PARALLEL_MAKE} "

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "0"
