SUMMARY = "Unit test for VIN-IMR-DRM camera capture pipe"
LICENSE = "CLOSED"

inherit cmake

S = "${WORKDIR}/git"

BRANCH = "rcar_gen3"
SRC_URI = "git://github.com/CogentEmbedded/utest-cam-imr-drm.git;branch=${BRANCH}"
SRCREV = "2e36dbc8edef1f3cfa013f674c7413dd1bf1167f"

PV = "v1.0+renesas+git"

DEPENDS = " \
    libspnav \
    libdrm \
    libinput \
    gstreamer1.0-plugins-base \
    mmngr-user-module \
    mmngrbuf-user-module \
"

do_install() {
    install -d ${D}${bindir}
    install -m 755 ${B}/utest/utest-cam-imr-drm ${D}${bindir}
}

EXTRA_OECMAKE += " -DCMAKE_SYSROOT=${STAGING_DIR_TARGET}"
