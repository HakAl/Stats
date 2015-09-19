//
// ImageUtils.java
// GiftCards Android App
//
// Created by acorll on 4/27/15 2:04 PM
// Copyright (c) 2007-2015 GiftCards.com.  All rights reserved.

package com.jacmobile.stats.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.Base64;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageUtils
{
    public static void tintDrawable(ImageView iv, int color)
    {
        Drawable d = DrawableCompat.wrap( iv.getDrawable() );
//        Drawable d = iv.getDrawable();
        DrawableCompat.setTint(d, color);
        iv.setImageDrawable(d);
    }
//    public static Drawable tintDrawable(Drawable d, int color)
//    {
//        d = DrawableCompat.wrap( d );
//        DrawableCompat.setTint(d, color);
//        return d;
//    }

    public static Bitmap getCircularBitmapImage(Bitmap source)
    {
        int size = Math.min(source.getWidth(), source.getHeight());
        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;
        Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
        if (squaredBitmap != source) {
            source.recycle();
        }
        Bitmap bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        BitmapShader shader = new BitmapShader(squaredBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setAntiAlias(true);
        float r = size / 2f;
        canvas.drawCircle(r, r, r, paint);
        squaredBitmap.recycle();
        return bitmap;
    }

    public static String encodeTobase64(Bitmap image)
    {
        Bitmap immagex = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

        return imageEncoded;
    }

    public static Bitmap drawableToBitmap(Drawable drawable)
    {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        int width = drawable.getIntrinsicWidth();
        width = width > 0 ? width : 1;
        int height = drawable.getIntrinsicHeight();
        height = height > 0 ? height : 1;

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    /**
     * Converts a Bitmap to a byteArray.
     */
    public static byte[] bitmapToByteArray(Bitmap bitmap)
    {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    /**
     * Converts a byteArray to a Bitmap object
     */
    public static Bitmap byteArrayToBitmap(byte[] byteArray)
    {
        if (byteArray == null) {
            return null;
        } else {
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }
    }

    /**
     * Shrinks and a passed Bitmap.
     */
    public static Bitmap shrinkBitmap(Bitmap bm, int maxLengthOfEdge)
    {
        return shrinkBitmap(bm, maxLengthOfEdge, 0);
    }

    /**
     * Shrinks and rotates (if necessary) a passed Bitmap.
     */
    public static Bitmap shrinkBitmap(Bitmap bm, int maxLengthOfEdge, int rotateXDegree)
    {
        if (maxLengthOfEdge > bm.getWidth() && maxLengthOfEdge > bm.getHeight()) {
            return bm;
        } else {
            // shrink image
            float scale = 1.0f;
            if (bm.getHeight() > bm.getWidth()) {
                scale = ((float) maxLengthOfEdge) / bm.getHeight();
            } else {
                scale = ((float) maxLengthOfEdge) / bm.getWidth();
            }
            // CREATE A MATRIX FOR THE MANIPULATION
            Matrix matrix = new Matrix();
            // RESIZE THE BIT MAP
            matrix.postScale(scale, scale);
            matrix.postRotate(rotateXDegree);

            // RECREATE THE NEW BITMAP
            bm = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(),
                    matrix, false);

            matrix = null;
            System.gc();

            return bm;
        }
    }

    public static Bitmap rotateBitmap(Bitmap bm, int rotateXDegree)
    {
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postRotate(rotateXDegree);

        // RECREATE THE NEW BITMAP
        bm = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), matrix, false);

        matrix = null;
        System.gc();

        return bm;
    }

    /**
     * Reads a Bitmap from an Uri.
     */
    public static Bitmap readBitmap(Context context, Uri selectedImage)
    {
        Bitmap bm = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inScaled = false;
//      options.inSampleSize = 3;
        AssetFileDescriptor fileDescriptor = null;
        try {
            fileDescriptor = context.getContentResolver().openAssetFileDescriptor(selectedImage, "r");
        } catch (FileNotFoundException e) {
            return null;
        } finally {
            try {
                bm = BitmapFactory.decodeFileDescriptor(
                        fileDescriptor.getFileDescriptor(), null, options);
                fileDescriptor.close();
            } catch (IOException e) {
                return null;
            }
        }
        return bm;
    }

    /**
     * Clears all Bitmap data, that is, recycles the Bitmap and
     * triggers the garbage collection.
     */
    public static void clearBitmap(Bitmap bm)
    {
        bm.recycle();
        System.gc();
    }


    /**
     * Deletes an image given its Uri and refreshes the gallery thumbnails.
     *
     * @return true if it was deleted successfully, false otherwise.
     */
    public static boolean deleteImageWithUriIfExists(Uri cameraPicUri, Context context)
    {
        try {
            if (cameraPicUri != null) {
                File fdelete = new File(cameraPicUri.getPath());
                if (fdelete.exists()) {
                    if (fdelete.delete()) {
                        refreshGalleryImages(context, fdelete);
                        return true;
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * Forces the Android gallery to  refresh its thumbnail images.
     */
    private static void refreshGalleryImages(Context context, File fdelete)
    {
        try {
            context.sendBroadcast(
                    new Intent(
                            Intent.ACTION_MEDIA_MOUNTED,
                            Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        } catch (Exception e1) {
            try {
                Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                Uri contentUri = Uri.fromFile(fdelete);
                mediaScanIntent.setData(contentUri);
                context.sendBroadcast(mediaScanIntent);
            } catch (Exception e2) {
            }
        }
    }
}