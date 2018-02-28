//== 类定义

var DatatableRecordSelectionUsers = function() {
	// == 私有函数

	var options = {
		// 数据源定义
		data: {
			type: 'remote',
			source: {
				read: {
					url: 'http://localhost:9999/users',
				},
			},
			pageSize: 10, // 页面大小
			serverPaging: true, // 服务端分页
			serverFiltering: true, // 服务端过滤
			serverSorting: true, // 服务端排序
		},

		// 布局定义
		layout: {
			theme: 'default', // 数据表格主题
			class: '', // 自定义封装类
			scroll: true, // 当需要的时候启用/禁用数据表格水平垂直双向滚动。
			height: 550, // 数据表格主体的固定高度
			footer: false // 显示/隐藏表格脚部
		},

		// 自定义排序
		sortable: false,

		// 是否分页
		pagination: true,

		// 列定义
		columns: [
			{
				field: 'ID',
				title: '#',
				sortable: false,
				width: 40,
				textAlign: 'center',
				selector: {class: 'm-checkbox--solid m-checkbox--brand'},
			}, 
// {
// field: 'openid',
// title: 'OpenID',
// width: 150,
// template: function(row) {
// // callback function support for column rendering
// return row.openid;
// },
// },
			{
				field: 'username',
				width: 100,
				title: '用户名',
			}, {
				field: 'signinType',
				width: 60,
				title: '登录类型',
				template: function(row) {
					var status = {
						"DEFAULT": {'title': 'DEFAULT', 'state': 'danger'},
						"WEIXIN" : {'title': 'WEIXIN', 'state': 'primary'},
						"WEIBO"  : {'title': 'WEIBO', 'state': 'accent'},
						"GITHUB" : {'title': 'GITHUB', 'state': 'accent'},
						"QQ"     : {'title': 'QQ', 'state': 'accent'},
						"SINA"   : {'title': 'SINA', 'state': 'accent'},
					};
					return '<span class="m--font-bold m--font-' + status[row.signinType].state + '">' + status[row.signinType].title + '</span>';
				 },
			}, {
				field: 'nickname',
				title: '昵称',
			}, {
				field: 'avatarUrl',
				title: '头像',
			}, {
				field: 'gender',
				width: 40,
				title: '性别',
			}, {
				field: 'email',
				width: 150,
				title: '邮箱',
			},  {
				field: 'phone',
				title: '手机号',
			},{
				field: 'userStatus',
				width: 80,
				title: '用户状态',
				template: function(row) {
					var status = {
						1: {'title': 'Pending', 'class': 'm-badge--brand'},
						2: {'title': 'Delivered', 'class': ' m-badge--metal'},
						3: {'title': 'Canceled', 'class': ' m-badge--primary'},
						4: {'title': 'Success', 'class': ' m-badge--success'},
						5: {'title': 'Info', 'class': ' m-badge--info'},
						6: {'title': 'Danger', 'class': ' m-badge--danger'},
						7: {'title': 'Warning', 'class': ' m-badge--warning'},
					};
					return '<span class="m-badge ' + status[row.userStatus+2].class + ' m-badge--wide">' + status[row.userStatus+2].title + '</span>';
				},
			},
			  {
				field: 'meta',
				title: '其他信息',
			},  {
				field: 'md5',
				width: 120,
				title: 'MD5',
			},  {
				field: 'created',
				title: '创建时间',
			},  {
				field: 'updated',
				title: '更新时间',
			},  {
				field: 'Actions',
				width: 110,
				title: '操作',
				sortable: false,
				overflow: 'visible',
				template: function (row, index, datatable) {
					var dropup = (datatable.getPageSize() - index) <= 4 ? 'dropup' : '';
					return '\
						<div class="dropdown ' + dropup + '">\
							<a href="#" class="btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill" data-toggle="dropdown">\
                                <i class="la la-ellipsis-h"></i>\
                            </a>\
						  	<div class="dropdown-menu dropdown-menu-right">\
						    	<a class="dropdown-item" href="#"><i class="la la-edit"></i> Edit Details</a>\
						    	<a class="dropdown-item" href="#"><i class="la la-leaf"></i> Update Status</a>\
						    	<a class="dropdown-item" href="#"><i class="la la-print"></i> Generate Report</a>\
						  	</div>\
						</div>\
						<a href="#" class="m-portlet__nav-link btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill" title="Edit details">\
							<i class="la la-edit"></i>\
						</a>\
						<a href="#" class="m-portlet__nav-link btn m-btn m-btn--hover-danger m-btn--icon m-btn--icon-only m-btn--pill" title="Delete">\
							<i class="la la-trash"></i>\
						</a>\
					';
				},
			}],
	};

	// 服务端选择
	var serverSelectorUsers = function() {

		// 允许拓展
		options.extensions = {
			checkbox: {},
		};
		options.search = {
			input: $('#generalSearch1'),
		};

		var datatable = $('#server_record_selection').mDatatable(options);

		$('#m_form_status1').on('change', function() {
			datatable.search($(this).val().toLowerCase(), 'Status');
		});

		$('#m_form_type1').on('change', function() {
			datatable.search($(this).val().toLowerCase(), 'Type');
		});

		$('#m_form_status1,#m_form_type1').selectpicker();

		datatable.on('m-datatable--on-click-checkbox m-datatable--on-layout-updated', function(e) {
			// datatable.checkbox() access to extension methods
			var ids = datatable.checkbox().getSelectedId();
			var count = ids.length;
			$('#m_datatable_selected_number1').html(count);
			if (count > 0) {
				$('#m_datatable_group_action_form1').collapse('show');
			} else {
				$('#m_datatable_group_action_form1').collapse('hide');
			}
		});

		$('#m_modal_fetch_id_server').on('show.bs.modal', function(e) {
			var ids = datatable.checkbox().getSelectedId();
			var c = document.createDocumentFragment();
			for (var i = 0; i < ids.length; i++) {
				var li = document.createElement('li');
				li.setAttribute('data-id', ids[i]);
				li.innerHTML = 'Selected record ID: ' + ids[i];
				c.appendChild(li);
			}
			$(e.target).find('.m_datatable_selected_ids').append(c);
		}).on('hide.bs.modal', function(e) {
			$(e.target).find('.m_datatable_selected_ids').empty();
		});

	};

	return {
		// 公共函数
		init: function() {
			serverSelectorUsers();
		},
	};
}();

jQuery(document).ready(function() {
	DatatableRecordSelectionUsers.init();
});