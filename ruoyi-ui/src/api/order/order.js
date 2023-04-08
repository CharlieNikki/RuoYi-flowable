import request from '@/utils/request'

// 查询委托单信息列表
export function listOrder(query) {
  return request({
    url: '/order/order/list',
    method: 'get',
    params: query
  })
}

// 查询委托单信息详细
export function getOrder(sampleId) {
  return request({
    url: '/order/order/' + sampleId,
    method: 'get'
  })
}

// 新增委托单信息
export function addOrder(data) {
  return request({
    url: '/order/order',
    method: 'post',
    data: data
  })
}

// 修改委托单信息
export function updateOrder(data) {
  return request({
    url: '/order/order',
    method: 'put',
    data: data
  })
}

// 删除委托单信息
export function delOrder(sampleId) {
  return request({
    url: '/order/order/' + sampleId,
    method: 'delete'
  })
}

// 下载导入模板
export function importTemplate() {
  return request({
    url: '/order/order/importTemplate',
    method: 'get'
  })
}

