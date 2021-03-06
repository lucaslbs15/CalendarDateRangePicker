package com.archit.calendardaterangepicker.models;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import com.archit.calendardaterangepicker.R;

public class CalendarStyleAttr {

    private Context context;

    private Typeface fonts;
    private Drawable headerBg;

    private int titleColor;

    private int weekColor;
    private int rangeStripColor;
    private int selectedDateCircleColor;
    private int selectedDateColor, defaultDateColor, disableDateColor, rangeDateColor;
    private float textSizeTitle, textSizeWeek, textSizeDate;
    private boolean shouldEnabledTime = false;
    private int weekOffset = 0;
    private boolean enabledPastDates = false;
    private boolean isEditable = true;
    private CharSequence subtitle;
    private boolean subtitleVisible;
    private int subtitleColor;
    private float subtitleSize;
    private float subtitleMarginTop;
    private float subtitleMarginBottom;
    private boolean showClearButton;
    private float clearSize;
    private float clearMarginTop;
    private float clearMarginBottom;
    private int clearTextColor;
    private int clearIcon;
    private float containerPaddingVertical;
    private float containerPaddingHorizontal;
    private int confirmButtonBackground;
    private float confirmButtonMarginTop;
    private String confirmButtonText;
    private float confirmButtonSize;
    private int confirmButtonTextColor;
    private boolean enableRange;
    private boolean disableWeekends;

    public CalendarStyleAttr(Context context) {
        this.context = context;
        setDefAttributes(context);
    }

    public CalendarStyleAttr(Context context, AttributeSet attributeSet) {
        this.context = context;
        setDefAttributes(context);
        setAttributes(context, attributeSet);
    }

    /**
     * To parse attributes from xml layout to configure calendar views.
     */
    public static CalendarStyleAttr getDefAttributes(Context context) {

        CalendarStyleAttr calendarStyleAttr = new CalendarStyleAttr(context);
        calendarStyleAttr.setTextSizeTitle(context.getResources().getDimension(R.dimen.text_size_title));
        calendarStyleAttr.setTextSizeWeek(context.getResources().getDimension(R.dimen.text_size_week));
        calendarStyleAttr.setTextSizeDate(context.getResources().getDimension(R.dimen.text_size_date));

        calendarStyleAttr.setWeekColor(ContextCompat.getColor(context, R.color.week_color));
        calendarStyleAttr.setRangeStripColor(ContextCompat.getColor(context, R.color.range_bg_color));
        calendarStyleAttr.setSelectedDateCircleColor(ContextCompat.getColor(context, R.color.selected_date_circle_color));
        calendarStyleAttr.setSelectedDateColor(ContextCompat.getColor(context, R.color.selected_date_color));
        calendarStyleAttr.setDefaultDateColor(ContextCompat.getColor(context, R.color.default_date_color));
        calendarStyleAttr.setRangeDateColor(ContextCompat.getColor(context, R.color.range_date_color));
        calendarStyleAttr.setDisableDateColor(ContextCompat.getColor(context, R.color.disable_date_color));

        return calendarStyleAttr;
    }

    /**
     * To parse attributes from xml layout to configure calendar views.
     */
    public void setDefAttributes(Context context) {

        setTextSizeTitle(context.getResources().getDimension(R.dimen.text_size_title));
        setTextSizeWeek(context.getResources().getDimension(R.dimen.text_size_week));
        setTextSizeDate(context.getResources().getDimension(R.dimen.text_size_date));

        setTitleColor(ContextCompat.getColor(context, R.color.title_color));
        setWeekColor(ContextCompat.getColor(context, R.color.week_color));
        setRangeStripColor(ContextCompat.getColor(context, R.color.range_bg_color));
        setSelectedDateCircleColor(ContextCompat.getColor(context, R.color.selected_date_circle_color));
        setSelectedDateColor(ContextCompat.getColor(context, R.color.selected_date_color));
        setDefaultDateColor(ContextCompat.getColor(context, R.color.default_date_color));
        setRangeDateColor(ContextCompat.getColor(context, R.color.range_date_color));
        setDisableDateColor(ContextCompat.getColor(context, R.color.disable_date_color));

        subtitle = context.getString(R.string.subtitle);
        subtitleSize = context.getResources().getDimension(R.dimen.text_size_subtitle);
        subtitleColor = ContextCompat.getColor(context, R.color.subtitle_color);
        subtitleMarginTop = context.getResources().getDimension(R.dimen.subtitle_margin_top);
        subtitleMarginBottom = context.getResources().getDimension(R.dimen.subtitle_margin_bottom);

        clearSize = context.getResources().getDimension(R.dimen.clear_text_size);
        clearMarginTop = context.getResources().getDimension(R.dimen.clear_margin_top);
        clearMarginBottom = context.getResources().getDimension(R.dimen.clear_margin_bottom);
        clearTextColor = ContextCompat.getColor(context, R.color.week_color);
        clearIcon = R.drawable.clear;

        containerPaddingVertical = context.getResources().getDimension(R.dimen.container_margin_vertical);
        containerPaddingHorizontal = context.getResources().getDimension(R.dimen.container_margin_horizontal);
        confirmButtonBackground = R.drawable.confirm_button_selector;
        confirmButtonMarginTop = context.getResources().getDimension(R.dimen.confirm_margin_top);
        confirmButtonSize = context.getResources().getDimension(R.dimen.confirm_text_size);
        confirmButtonText = context.getString(R.string.confirm);
        confirmButtonTextColor = ContextCompat.getColor(context, R.color.confirm_text);
    }

    public void setAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray ta = context.obtainStyledAttributes(attributeSet, R.styleable.DateRangeMonthView, 0, 0);
            try {
                titleColor = ta.getColor(R.styleable.DateRangeMonthView_title_color, titleColor);
                headerBg = ta.getDrawable(R.styleable.DateRangeMonthView_header_bg);
                weekColor = ta.getColor(R.styleable.DateRangeMonthView_week_color, weekColor);
                rangeStripColor = ta.getColor(R.styleable.DateRangeMonthView_range_color, rangeStripColor);
                selectedDateCircleColor = ta.getColor(R.styleable.DateRangeMonthView_selected_date_circle_color, selectedDateCircleColor);
                shouldEnabledTime = ta.getBoolean(R.styleable.DateRangeMonthView_enable_time_selection, false);
                enabledPastDates = ta.getBoolean(R.styleable.DateRangeMonthView_enable_past_date,false);
                isEditable = ta.getBoolean(R.styleable.DateRangeMonthView_editable,true);
                enableRange = ta.getBoolean(R.styleable.DateRangeMonthView_enable_range,true);
                disableWeekends = ta.getBoolean(R.styleable.DateRangeMonthView_disable_weekends,false);

                textSizeTitle = ta.getDimension(R.styleable.DateRangeMonthView_text_size_title, textSizeTitle);
                textSizeWeek = ta.getDimension(R.styleable.DateRangeMonthView_text_size_week, textSizeWeek);
                textSizeDate = ta.getDimension(R.styleable.DateRangeMonthView_text_size_date, textSizeDate);

                selectedDateColor = ta.getColor(R.styleable.DateRangeMonthView_selected_date_color, selectedDateColor);
                defaultDateColor = ta.getColor(R.styleable.DateRangeMonthView_default_date_color, defaultDateColor);
                rangeDateColor = ta.getColor(R.styleable.DateRangeMonthView_range_date_color, rangeDateColor);
                disableDateColor = ta.getColor(R.styleable.DateRangeMonthView_disable_date_color, disableDateColor);
                setWeekOffset(ta.getColor(R.styleable.DateRangeMonthView_week_offset, 0));

                subtitle = ta.getText(R.styleable.DateRangeMonthView_subtitle_text) == null ? subtitle : ta.getText(R.styleable.DateRangeMonthView_subtitle_text);
                subtitleVisible = ta.getBoolean(R.styleable.DateRangeMonthView_subtitle_visible, false);
                subtitleColor = ta.getColor(R.styleable.DateRangeMonthView_subtitle_color, defaultDateColor);
                subtitleSize = ta.getDimension(R.styleable.DateRangeMonthView_subtitle_size, subtitleSize);
                subtitleMarginTop = ta.getDimension(R.styleable.DateRangeMonthView_subtitle_margin_top, subtitleMarginTop);
                subtitleMarginBottom = ta.getDimension(R.styleable.DateRangeMonthView_subtitle_margin_bottom, subtitleMarginBottom);
                showClearButton = ta.getBoolean(R.styleable.DateRangeMonthView_show_clear_button, false);

                clearSize = ta.getDimension(R.styleable.DateRangeMonthView_clear_size, clearSize);
                clearMarginTop = ta.getDimension(R.styleable.DateRangeMonthView_clear_margin_top, clearMarginTop);
                clearMarginBottom = ta.getDimension(R.styleable.DateRangeMonthView_clear_margin_bottom, clearMarginBottom);
                clearTextColor = ta.getColor(R.styleable.DateRangeMonthView_clear_text_color, clearTextColor);
                clearIcon = ta.getResourceId(R.styleable.DateRangeMonthView_clear_icon, clearIcon);

                containerPaddingVertical = ta.getDimension(R.styleable.DateRangeMonthView_container_margin_vertical, containerPaddingVertical);
                containerPaddingHorizontal = ta.getDimension(R.styleable.DateRangeMonthView_container_margin_horizontal, containerPaddingHorizontal);

                confirmButtonBackground = ta.getResourceId(R.styleable.DateRangeMonthView_confirm_button_background, confirmButtonBackground);
                confirmButtonMarginTop = ta.getDimension(R.styleable.DateRangeMonthView_confirm_button_margin_top, confirmButtonMarginTop);
                confirmButtonText = ta.getString(R.styleable.DateRangeMonthView_confirm_button_text) == null ? confirmButtonText : ta.getString(R.styleable.DateRangeMonthView_confirm_button_text);
                confirmButtonSize = ta.getDimension(R.styleable.DateRangeMonthView_confirm_button_size, confirmButtonSize);
                confirmButtonTextColor = ta.getColor(R.styleable.DateRangeMonthView_confirm_button_text_color, confirmButtonTextColor);
            } finally {
                ta.recycle();
            }
        }
    }

    public Typeface getFonts() {
        return fonts;
    }

    public void setFonts(Typeface fonts) {
        this.fonts = fonts;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
    }

    public Drawable getHeaderBg() {
        return headerBg;
    }

    public void setHeaderBg(Drawable headerBg) {
        this.headerBg = headerBg;
    }

    public int getWeekColor() {
        return weekColor;
    }

    public void setWeekColor(int weekColor) {
        this.weekColor = weekColor;
    }

    public int getRangeStripColor() {
        return rangeStripColor;
    }

    public void setRangeStripColor(int rangeStripColor) {
        this.rangeStripColor = rangeStripColor;
    }

    public int getSelectedDateCircleColor() {
        return selectedDateCircleColor;
    }

    public void setSelectedDateCircleColor(int selectedDateCircleColor) {
        this.selectedDateCircleColor = selectedDateCircleColor;
    }

    public int getSelectedDateColor() {
        return selectedDateColor;
    }

    public void setSelectedDateColor(int selectedDateColor) {
        this.selectedDateColor = selectedDateColor;
    }

    public int getDefaultDateColor() {
        return defaultDateColor;
    }

    public void setDefaultDateColor(int defaultDateColor) {
        this.defaultDateColor = defaultDateColor;
    }

    public int getDisableDateColor() {
        return disableDateColor;
    }

    public void setDisableDateColor(int disableDateColor) {
        this.disableDateColor = disableDateColor;
    }

    public int getRangeDateColor() {
        return rangeDateColor;
    }

    public void setRangeDateColor(int rangeDateColor) {
        this.rangeDateColor = rangeDateColor;
    }

    public float getTextSizeTitle() {
        return textSizeTitle;
    }

    public void setTextSizeTitle(float textSizeTitle) {
        this.textSizeTitle = textSizeTitle;
    }

    public float getTextSizeWeek() {
        return textSizeWeek;
    }

    public void setTextSizeWeek(float textSizeWeek) {
        this.textSizeWeek = textSizeWeek;
    }

    public float getTextSizeDate() {
        return textSizeDate;
    }

    public void setTextSizeDate(float textSizeDate) {
        this.textSizeDate = textSizeDate;
    }

    public boolean isShouldEnabledTime() {
        return shouldEnabledTime;
    }

    public void setShouldEnabledTime(boolean shouldEnabledTime) {
        this.shouldEnabledTime = shouldEnabledTime;
    }

    public int getWeekOffset() {
        return weekOffset;
    }

    public boolean isEnabledPastDates() {
        return enabledPastDates;
    }

    public void setEnabledPastDates(boolean enabledPastDates) {
        this.enabledPastDates = enabledPastDates;
    }

    public boolean isEnableRange() {
        return enableRange;
    }

    public void setEnableRange(boolean enableRange) {
        this.enableRange = enableRange;
    }

    public boolean isDisableWeekends() {
        return disableWeekends;
    }

    /**
     * To set week offset
     *
     * @param weekOffset
     */
    public void setWeekOffset(int weekOffset) {
        if (weekOffset < 0 || weekOffset > 6) {
            throw new RuntimeException("Week offset can only be between 0 to 6. " +
                    "0->Sun, 1->Mon, 2->Tue, 3->Wed, 4->Thu, 5->Fri, 6->Sat");
        }
        this.weekOffset = weekOffset;
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean editable) {
        isEditable = editable;
    }

    public String getSubtitle() {
        return subtitle.toString();
    }

    public boolean isSubtitleVisible() {
        return subtitleVisible;
    }

    public int getSubtitleColor() {
        return subtitleColor;
    }

    public float getSubtitleSize() {
        float scaleRatio = context.getResources().getDisplayMetrics().density;
        return subtitleSize / scaleRatio;
    }

    public int getSubtitleMarginTop() {
        return (int) subtitleMarginTop;
    }

    public int getSubtitleMarginBottom() {
        return (int) subtitleMarginBottom;
    }

    public boolean shouldShowClearButton() {
        return showClearButton;
    }

    public float getClearSize() {
        float scaleRatio = context.getResources().getDisplayMetrics().density;
        return clearSize / scaleRatio;
    }

    public int getClearMarginTop() {
        return (int) clearMarginTop;
    }

    public int getClearMarginBottom() {
        return (int) clearMarginBottom;
    }

    public int getClearTextColor() {
        return clearTextColor;
    }

    public int getClearIcon() {
        return clearIcon;
    }

    public int getContainerPaddingVertical() {
        return (int) containerPaddingVertical;
    }

    public int getContainerPaddingHorizontal() {
        return (int) containerPaddingHorizontal;
    }

    public int getConfirmButtonBackground() {
        return confirmButtonBackground;
    }

    public int getConfirmButtonMarginTop() {
        return (int) confirmButtonMarginTop;
    }

    public String getConfirmButtonText() {
        return confirmButtonText;
    }

    public float getConfirmButtonSize() {
        float scaleRatio = context.getResources().getDisplayMetrics().density;
        return confirmButtonSize / scaleRatio;
    }

    public int getConfirmButtonTextColor() {
        return confirmButtonTextColor;
    }
}
