require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot-common.inc
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SUMMARY = "u-boot bootloader for beaglebone"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=5a7450c57ffe5ae63fd732446b988025"

COMPATIBLE_MACHINE = "(beaglebone)"

UBOOT_TAG = "v${PV}"
UBOOT_GIT_URI = "git://git.denx.de/u-boot.git"
UBOOT_GIT_PROTOCOL = "git"

SRC_URI = "${UBOOT_GIT_URI};protocol=${UBOOT_GIT_PROTOCOL};tag=${UBOOT_TAG}"
SRCREV = "${UBOOT_TAG}"

DEPENDS += "bc-native dtc-native"

S = "${WORKDIR}/git"
