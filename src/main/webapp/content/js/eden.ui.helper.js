var EDEN_UI_HELPER = function () {
    // jquery.validate.js need every element have the unique id, so set the id after bootstrap-datepicker.js confuse the element id.
    var date_picker_id_sequence = 0;

    var pad = function (val, len) {
        val = String(val);
        len = len || 2;
        while (val.length < len) val = "0" + val;
        return val;
    };

    return {
        BindRowSelectToCheckboxForTable: function (table) {
            var previous_row_idx = -1;
            var SELECTED_ROW_COLOR = '#FDAB55';
            var rows = table.find("tbody tr");
           
            rows.find(":checkbox").on("click", function (e) {
                e.stopPropagation();
                e.preventDefault();
            });
            rows.on("mousedown", function (e) {
                var row_idx = this.rowIndex;
                var row = $(this);
                if (e.shiftKey && previous_row_idx != -1) {
                    var from = previous_row_idx, to = row_idx;
                    if (from > to) {
                        from = row_idx;
                        to = previous_row_idx;
                    }
                    //console.log(from + " " + to);
                    table.find('tr:gt(' + (from-1) + '):lt(' + (to - from + 1) + ')')
                        .css({ background: SELECTED_ROW_COLOR })
                    .find(":checkbox").prop("checked", true);
                    previous_row_idx = -1;
                    
                }
                else {
                    var cb = row.find(":checkbox");
                    cb.prop("checked", !(cb.prop("checked")));
                    
                    if (cb.prop("checked") == true) {
                        row.css({ background: SELECTED_ROW_COLOR });
                    }
                    else {
                        row.css({ background: '' })
                    }

                    previous_row_idx = row_idx;
                }
                e.preventDefault();
                return false;
            });
        },

        BindRowSelectToCheckboxForTable2: function (table) {
            var previous_row_idx = -1;
            var SELECTED_ROW_COLOR = '#FDAB55';
            var rows = table.find("tbody tr");

            rows.find(":checkbox").on("click", function (e) {
                e.stopPropagation();
                e.preventDefault();
            });
            rows.on("mousedown", function (e) {
                var row_idx = this.rowIndex;
                var row = $(this);
                if (e.shiftKey && previous_row_idx != -1) {
                    var from = previous_row_idx, to = row_idx;
                    if (from > to) {
                        from = row_idx;
                        to = previous_row_idx;
                    }
                    //console.log(from + " " + to);
                    var oldermoney=$('#selAmount').html();
                    table.find('tr:gt(' + (from-1) + '):lt(' + (to - from + 1) + ')')
                        .css({ background: SELECTED_ROW_COLOR })
                        .each(function(){
                            //console.log($(this));
                            //console.log($(this).find(":checkbox").prop("checked"));
                            //console.log($(this).data("currentmoney"));

                            if(!($(this).find(":checkbox").prop("checked"))) {
                                oldermoney = parseFloat(oldermoney) + parseFloat($(this).data("currentmoney"));
                                $('#selAmount').html(parseFloat(oldermoney));
                            }
                        })
                        .find(":checkbox")
                        .prop("checked", true)

                    $('#selAmount').html(parseFloat(oldermoney).toFixed(2));

                    previous_row_idx = -1;

                }
                else {
                    var cb = row.find(":checkbox");
                    cb.prop("checked", !(cb.prop("checked")));

                    if (cb.prop("checked") == true) {
                        row.css({ background: SELECTED_ROW_COLOR });
                        var oldermoney=$('#selAmount').html();

                        oldermoney=parseFloat(oldermoney)+parseFloat(row.data("currentmoney"));
                        //console.info("current"+parseFloat(row.data("currentmoney")) +"ADD:::"+oldermoney);
                        $('#selAmount').html(parseFloat(oldermoney).toFixed(2));
                    }
                    else {
                        row.css({ background: '' });

                        var oldermoney=$('#selAmount').html();
                        oldermoney=parseFloat(oldermoney)-parseFloat(row.data("currentmoney"));

                        if(parseFloat(oldermoney)<0) {
                            oldermoney = 0;
                        }
                        //console.info("current"+parseFloat(row.data("currentmoney")) +"SUB:::"+oldermoney);
                        $('#selAmount').html(parseFloat(oldermoney).toFixed(2));


                    }

                    previous_row_idx = row_idx;
                }
                e.preventDefault();
                return false;
            });
        },


        PairRadioOrCheckboxWithTextbox: function (container) {
            container = container || $('.js-radio-checkbox-text');
            container.each(function (i, elem) {
                var radioAndCheckbox = $(elem).find(':radio:last, :checkbox:last'),
                    textbox = $(elem).find(':text');
                radioAndCheckbox.on('click', function () {
                    if (this.checked) {
                        textbox.focus();
                    }
                });
                textbox.on('focus', function () {
                    radioAndCheckbox.attr('checked', 'checked');
                });
            });
        },
        HookDatePicker: function (container) {
            var controls = ((container == undefined) ? $(".js-date-picker") : container.find(".js-date-picker"));
            $.each(controls, function (k, v) {
                $(v).attr('id', 'date-picker-' + (++date_picker_id_sequence))
                //.attr("readonly", "readonly")
                .datepicker({ "format": "yyyy-mm-dd", "language": 'zh-CN', "autoclose": true })
                .on('changeDate', function (ev) {
                    $(this).blur();
                });
            });
        },
        HookDateTimePicker: function (container) {
            var controls = ((container == undefined) ? $(".js-datetime-picker") : container.find(".js-datetime-picker"));
            $.each(controls, function (k, v) {
                $(v).attr('id', 'datetime-picker-' + (++date_picker_id_sequence))
                //.attr("readonly", "readonly")
                .datetimepicker({ "format": "yyyy-mm-dd hh:ii:ss", "language": 'zh-CN', "autoclose": true })
                .on('changeDate', function (ev) {
                    $(this).blur();
                });
            });
        },

        HookHourMinPicker: function (container) {
            var controls = ((container == undefined) ? $(".js-hourMin-picker") : container.find(".js-hourMin-picker"));
            $.each(controls, function (k, v) {
                $(v).attr('id', 'datetimeHourMin-picker-' + (++date_picker_id_sequence))
                    //.attr("readonly", "readonly")
                    .datetimepicker({ "format": "hh:ii:00", "language": 'zh-CN', "autoclose": true,"startView": 1 })
                    .on('changeDate', function (ev) {
                        $(this).blur();
                    });
            });
        },



        HookDateTimeHourPicker: function (container) {
            var controls = ((container == undefined) ? $(".js-datetimeHour-picker") : container.find(".js-datetimeHour-picker"));
            $.each(controls, function (k, v) {
                $(v).attr('id', 'datetimeHour-picker-' + (++date_picker_id_sequence))
                    //.attr("readonly", "readonly")
                    .datetimepicker({ "format": "yyyy-mm-dd hh:ii:00", "language": 'zh-CN', "autoclose": true })
                    .on('changeDate', function (ev) {
                        $(this).blur();
                    });
            });
        },
        HookLookup: function (container) {
            var controls = ((container == undefined) ? $(".js-lookup") : container.find(".js-lookup"));
            $.each(controls, function (k, v) {
                var treeID = parseInt($(v).attr("ui-tree-id"), 10);
                EDEN_TREE.BindLookup($(v), treeID);
            });
        },
        HookFlotLookup: function (container) {
            var controls = ((container == undefined) ? $(".js-flat-lookup") : container.find(".js-flat-lookup"));
            $.each(controls, function (k, v) {
                var treeID = parseInt($(v).attr("ui-tree-id"), 10);
                EDEN_TREE.BindFlatLookup($(v), treeID);
            });
        },
        HookAutoComplete: function (container) {
            var controls = ((container == undefined) ? $(".js-auto-complete") : container.find(".js-auto-complete"));
            $.each(controls, function (k, v) {
                var treeID = parseInt($(v).attr("ui-tree-id"), 10);
                EDEN_TREE.BindAutoComplete($(v), treeID);
            });
        },
        // yyyy-mm-dd
        ISODate: function (d) {
            if (d instanceof Date) {
                return d.getFullYear() + "-" + pad(d.getMonth() + 1, 2) + "-" + pad(d.getDate(),2);
            }
            return '';
        },
        // entities: all entities for all rows
        // entity: default entity for new row
        // collection_name: the control name will be "collection_name[index].control_name"
        // row_tag: row html tag
        // column_tag: column html tag
        // $container: the closest container with all rows
        // template: row html template
        EditableCollection: function (entities, entity, collection_name, row_tag, column_tag, $container, template) {
            var $form = $container.closest("form");
            var row_sequence = 0;

            function fixControlNameInRow(index, entity) {
                var row = $container.find(row_tag + ":eq(" + index + ")");
                // ASP.NET MVC model binding for collection need a "collection_name.Index" 
                row.find("[name='" + collection_name + ".Index']").val(row_sequence);
                $.each(entity, function (name, value) {
                    var control = row.find("[name$='" + name + "']");
                    if (control.length != 0) {
                        var new_name = collection_name + "[" + row_sequence + "]." + name;
                        control.attr("name", new_name);
                        control.closest(column_tag).find(".js-validation-message").attr("data-valmsg-for", new_name);
                        if (control.attr('type') == 'checkbox') {
                            control[0].checked = value;
                        }
                        else if (control.hasClass("js-date-picker")) {
                            control.val(EDEN_UI_HELPER.ISODate(value));
                        }
                        else {
                            control.val(value);
                        }
                    }
                });
                row_sequence++;
                return row;
            }

            function validation() {
                $form.removeData("validator").removeData("unobtrusiveValidation");
                $.validator.unobtrusive.parse($form);
            }

            function bind() {
                row_sequence = 0;
                if (entities == null) {
                    return;
                }
                $.each(entities, function (index, entity) {
                    $container.append(template);
                    fixControlNameInRow(index, entity);
                });
            }

            return {
                Insert: function () {
                    $container.prepend(template);
                    var row = addRow(0, entity);
                    EDEN_UI_HELPER.HookDatePicker(row);
                    validation();
                    return this;
                },
                Add: function () {
                    $container.append(template);
                    var row = fixControlNameInRow($container.find('tr').length - 1, entity);
                    EDEN_UI_HELPER.HookDatePicker(row);
                    validation();
                    return this;
                },
                Delete: function ($button) {
                    $button.closest(row_tag).remove();
                    EDEN_UI_HELPER.HookDatePicker();
                    validation();
                    return this;
                },
                Empty: function () {
                    $container.empty();
                    EDEN_UI_HELPER.HookDatePicker();
                    validation();
                    return this;
                },
                Reset: function () {
                    $container.empty();
                    bind();
                    EDEN_UI_HELPER.HookDatePicker();
                    validation();
                    return this;
                },
                Each: function (index, callback) {
                    var row = $container.find(row_tag + ":eq(" + index + ")");
                    var entity = entities[index];
                    if (callback) {
                        callback(row, entity);
                    }
                },
                Entities: entities
            };
        }
    };
}();
