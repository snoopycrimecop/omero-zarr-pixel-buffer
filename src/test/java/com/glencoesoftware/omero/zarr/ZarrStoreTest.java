package com.glencoesoftware.omero.zarr;

import org.junit.Assert;
import org.junit.Test;

/** Unit test for ZarrStore. */
public class ZarrStoreTest {

    @Test
    public void testRemoveQuery() {
        Assert.assertEquals("/my/test/path",
            ZarrStore.removeQuery("/my/test/path?test=zarr.zarr"));

        Assert.assertEquals("/my/test/path",
            ZarrStore.removeQuery("/my/test/path?query=test1?query=test2"));

        Assert.assertEquals("/my/test/path",
                ZarrStore.removeQuery("/my/test/path?/more/path/stuff/query=test1"));

        Assert.assertEquals("/my/test/path",
                ZarrStore.removeQuery("/my/test/path?/more?/path?/stuff?/query=test1"));

        Assert.assertEquals("/my/test/path/myfile.zarr",
                ZarrStore.removeQuery("/my/test/path/myfile.zarr?anonymous=true"));

        Assert.assertEquals("", ZarrStore.removeQuery("?query=test1"));
    }

    @Test
    public void testRemoveNothing() {

        Assert.assertEquals("", ZarrStore.removeQuery(""));

        Assert.assertEquals("/my/test/path?test-zarr.zarr",
                ZarrStore.removeQuery("/my/test/path?test-zarr.zarr"));

        Assert.assertEquals("/my/test/path=test?zarr.zarr",
                ZarrStore.removeQuery("/my/test/path=test?zarr.zarr"));

        Assert.assertEquals("/my/test/path.zarr",
                ZarrStore.removeQuery("/my/test/path.zarr"));
    }

    @Test
    public void testMatch() {
        Assert.assertTrue(ZarrStore.containsQueryString("?query=only"));
        Assert.assertTrue(ZarrStore.containsQueryString("path?matches=query"));
        Assert.assertTrue(ZarrStore.containsQueryString("my/zarr/path.zarr?matches=query"));
        Assert.assertTrue(ZarrStore.containsQueryString(
                "my/zarr/path.zarr/?te/st?1/23?matches=query=test"));
        Assert.assertTrue(ZarrStore.containsQueryString(
                "   my/zarr/path with spaces.zarr?  weird = query   "));
        Assert.assertTrue(ZarrStore.containsQueryString(" ? = "));
    }

    @Test
    public void testNoMatch() {
        Assert.assertFalse(ZarrStore.containsQueryString(""));
        Assert.assertFalse(ZarrStore.containsQueryString("?="));
        Assert.assertFalse(ZarrStore.containsQueryString("?=afteronly"));
        Assert.assertFalse(ZarrStore.containsQueryString("beforeonly?="));
        Assert.assertFalse(ZarrStore.containsQueryString("?middleonly="));
        Assert.assertFalse(ZarrStore.containsQueryString("my/zarr/path.zarr"));
        Assert.assertFalse(ZarrStore.containsQueryString("my/zarr/path=test?zarr"));
    }

}
