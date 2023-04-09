import request from '@/utils/request'

// 查询设备管理列表
export function listDevice(query) {
  return request({
    url: '/device/device/list',
    method: 'get',
    params: query
  })
}

// 查询设备管理详细
export function getDevice(id) {
  return request({
    url: '/device/device/' + id,
    method: 'get'
  })
}

// 新增设备管理
export function addDevice(data) {
  return request({
    url: '/device/device',
    method: 'post',
    data: data
  })
}

// 修改设备管理
export function updateDevice(data) {
  return request({
    url: '/device/device',
    method: 'put',
    data: data
  })
}

// 删除设备管理
export function delDevice(id) {
  return request({
    url: '/device/device/' + id,
    method: 'delete'
  })
}
// 下载导入模板
export function importTemplate() {
  return request({
    url: '/device/device/importTemplate',
    method: 'get'
  })
}

