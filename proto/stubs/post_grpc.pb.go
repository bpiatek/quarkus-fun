// Code generated by protoc-gen-go-grpc. DO NOT EDIT.
// versions:
// - protoc-gen-go-grpc v1.3.0
// - protoc             (unknown)
// source: post.proto

package posts_v1

import (
	context "context"
	grpc "google.golang.org/grpc"
	codes "google.golang.org/grpc/codes"
	status "google.golang.org/grpc/status"
)

// This is a compile-time assertion to ensure that this generated file
// is compatible with the grpc package it is being compiled against.
// Requires gRPC-Go v1.32.0 or later.
const _ = grpc.SupportPackageIsVersion7

const (
	PostApi_GetPosts_FullMethodName   = "/posts.v1.PostApi/GetPosts"
	PostApi_SavePost_FullMethodName   = "/posts.v1.PostApi/SavePost"
	PostApi_UpdatePost_FullMethodName = "/posts.v1.PostApi/UpdatePost"
)

// PostApiClient is the client API for PostApi service.
//
// For semantics around ctx use and closing/ending streaming RPCs, please refer to https://pkg.go.dev/google.golang.org/grpc/?tab=doc#ClientConn.NewStream.
type PostApiClient interface {
	GetPosts(ctx context.Context, in *GetPostsRequest, opts ...grpc.CallOption) (*PostsResponse, error)
	SavePost(ctx context.Context, in *PostCreateRequest, opts ...grpc.CallOption) (*PostResponse, error)
	UpdatePost(ctx context.Context, in *PostUpdateRequest, opts ...grpc.CallOption) (*PostResponse, error)
}

type postApiClient struct {
	cc grpc.ClientConnInterface
}

func NewPostApiClient(cc grpc.ClientConnInterface) PostApiClient {
	return &postApiClient{cc}
}

func (c *postApiClient) GetPosts(ctx context.Context, in *GetPostsRequest, opts ...grpc.CallOption) (*PostsResponse, error) {
	out := new(PostsResponse)
	err := c.cc.Invoke(ctx, PostApi_GetPosts_FullMethodName, in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *postApiClient) SavePost(ctx context.Context, in *PostCreateRequest, opts ...grpc.CallOption) (*PostResponse, error) {
	out := new(PostResponse)
	err := c.cc.Invoke(ctx, PostApi_SavePost_FullMethodName, in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *postApiClient) UpdatePost(ctx context.Context, in *PostUpdateRequest, opts ...grpc.CallOption) (*PostResponse, error) {
	out := new(PostResponse)
	err := c.cc.Invoke(ctx, PostApi_UpdatePost_FullMethodName, in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// PostApiServer is the server API for PostApi service.
// All implementations must embed UnimplementedPostApiServer
// for forward compatibility
type PostApiServer interface {
	GetPosts(context.Context, *GetPostsRequest) (*PostsResponse, error)
	SavePost(context.Context, *PostCreateRequest) (*PostResponse, error)
	UpdatePost(context.Context, *PostUpdateRequest) (*PostResponse, error)
	mustEmbedUnimplementedPostApiServer()
}

// UnimplementedPostApiServer must be embedded to have forward compatible implementations.
type UnimplementedPostApiServer struct {
}

func (UnimplementedPostApiServer) GetPosts(context.Context, *GetPostsRequest) (*PostsResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetPosts not implemented")
}
func (UnimplementedPostApiServer) SavePost(context.Context, *PostCreateRequest) (*PostResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method SavePost not implemented")
}
func (UnimplementedPostApiServer) UpdatePost(context.Context, *PostUpdateRequest) (*PostResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method UpdatePost not implemented")
}
func (UnimplementedPostApiServer) mustEmbedUnimplementedPostApiServer() {}

// UnsafePostApiServer may be embedded to opt out of forward compatibility for this service.
// Use of this interface is not recommended, as added methods to PostApiServer will
// result in compilation errors.
type UnsafePostApiServer interface {
	mustEmbedUnimplementedPostApiServer()
}

func RegisterPostApiServer(s grpc.ServiceRegistrar, srv PostApiServer) {
	s.RegisterService(&PostApi_ServiceDesc, srv)
}

func _PostApi_GetPosts_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GetPostsRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(PostApiServer).GetPosts(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: PostApi_GetPosts_FullMethodName,
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(PostApiServer).GetPosts(ctx, req.(*GetPostsRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _PostApi_SavePost_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(PostCreateRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(PostApiServer).SavePost(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: PostApi_SavePost_FullMethodName,
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(PostApiServer).SavePost(ctx, req.(*PostCreateRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _PostApi_UpdatePost_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(PostUpdateRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(PostApiServer).UpdatePost(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: PostApi_UpdatePost_FullMethodName,
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(PostApiServer).UpdatePost(ctx, req.(*PostUpdateRequest))
	}
	return interceptor(ctx, in, info, handler)
}

// PostApi_ServiceDesc is the grpc.ServiceDesc for PostApi service.
// It's only intended for direct use with grpc.RegisterService,
// and not to be introspected or modified (even as a copy)
var PostApi_ServiceDesc = grpc.ServiceDesc{
	ServiceName: "posts.v1.PostApi",
	HandlerType: (*PostApiServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "GetPosts",
			Handler:    _PostApi_GetPosts_Handler,
		},
		{
			MethodName: "SavePost",
			Handler:    _PostApi_SavePost_Handler,
		},
		{
			MethodName: "UpdatePost",
			Handler:    _PostApi_UpdatePost_Handler,
		},
	},
	Streams:  []grpc.StreamDesc{},
	Metadata: "post.proto",
}

const (
	AuthorApi_GetAuthors_FullMethodName   = "/posts.v1.AuthorApi/GetAuthors"
	AuthorApi_SaveAuthor_FullMethodName   = "/posts.v1.AuthorApi/SaveAuthor"
	AuthorApi_UpdateAuthor_FullMethodName = "/posts.v1.AuthorApi/UpdateAuthor"
	AuthorApi_GetById_FullMethodName      = "/posts.v1.AuthorApi/GetById"
)

// AuthorApiClient is the client API for AuthorApi service.
//
// For semantics around ctx use and closing/ending streaming RPCs, please refer to https://pkg.go.dev/google.golang.org/grpc/?tab=doc#ClientConn.NewStream.
type AuthorApiClient interface {
	GetAuthors(ctx context.Context, in *GetAuthorsRequest, opts ...grpc.CallOption) (*AuthorsResponse, error)
	SaveAuthor(ctx context.Context, in *AuthorCreateRequest, opts ...grpc.CallOption) (*AuthorResponse, error)
	UpdateAuthor(ctx context.Context, in *AuthorUpdateRequest, opts ...grpc.CallOption) (*AuthorResponse, error)
	GetById(ctx context.Context, in *GetAuthorRequest, opts ...grpc.CallOption) (*AuthorResponse, error)
}

type authorApiClient struct {
	cc grpc.ClientConnInterface
}

func NewAuthorApiClient(cc grpc.ClientConnInterface) AuthorApiClient {
	return &authorApiClient{cc}
}

func (c *authorApiClient) GetAuthors(ctx context.Context, in *GetAuthorsRequest, opts ...grpc.CallOption) (*AuthorsResponse, error) {
	out := new(AuthorsResponse)
	err := c.cc.Invoke(ctx, AuthorApi_GetAuthors_FullMethodName, in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *authorApiClient) SaveAuthor(ctx context.Context, in *AuthorCreateRequest, opts ...grpc.CallOption) (*AuthorResponse, error) {
	out := new(AuthorResponse)
	err := c.cc.Invoke(ctx, AuthorApi_SaveAuthor_FullMethodName, in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *authorApiClient) UpdateAuthor(ctx context.Context, in *AuthorUpdateRequest, opts ...grpc.CallOption) (*AuthorResponse, error) {
	out := new(AuthorResponse)
	err := c.cc.Invoke(ctx, AuthorApi_UpdateAuthor_FullMethodName, in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *authorApiClient) GetById(ctx context.Context, in *GetAuthorRequest, opts ...grpc.CallOption) (*AuthorResponse, error) {
	out := new(AuthorResponse)
	err := c.cc.Invoke(ctx, AuthorApi_GetById_FullMethodName, in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// AuthorApiServer is the server API for AuthorApi service.
// All implementations must embed UnimplementedAuthorApiServer
// for forward compatibility
type AuthorApiServer interface {
	GetAuthors(context.Context, *GetAuthorsRequest) (*AuthorsResponse, error)
	SaveAuthor(context.Context, *AuthorCreateRequest) (*AuthorResponse, error)
	UpdateAuthor(context.Context, *AuthorUpdateRequest) (*AuthorResponse, error)
	GetById(context.Context, *GetAuthorRequest) (*AuthorResponse, error)
	mustEmbedUnimplementedAuthorApiServer()
}

// UnimplementedAuthorApiServer must be embedded to have forward compatible implementations.
type UnimplementedAuthorApiServer struct {
}

func (UnimplementedAuthorApiServer) GetAuthors(context.Context, *GetAuthorsRequest) (*AuthorsResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetAuthors not implemented")
}
func (UnimplementedAuthorApiServer) SaveAuthor(context.Context, *AuthorCreateRequest) (*AuthorResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method SaveAuthor not implemented")
}
func (UnimplementedAuthorApiServer) UpdateAuthor(context.Context, *AuthorUpdateRequest) (*AuthorResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method UpdateAuthor not implemented")
}
func (UnimplementedAuthorApiServer) GetById(context.Context, *GetAuthorRequest) (*AuthorResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetById not implemented")
}
func (UnimplementedAuthorApiServer) mustEmbedUnimplementedAuthorApiServer() {}

// UnsafeAuthorApiServer may be embedded to opt out of forward compatibility for this service.
// Use of this interface is not recommended, as added methods to AuthorApiServer will
// result in compilation errors.
type UnsafeAuthorApiServer interface {
	mustEmbedUnimplementedAuthorApiServer()
}

func RegisterAuthorApiServer(s grpc.ServiceRegistrar, srv AuthorApiServer) {
	s.RegisterService(&AuthorApi_ServiceDesc, srv)
}

func _AuthorApi_GetAuthors_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GetAuthorsRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(AuthorApiServer).GetAuthors(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: AuthorApi_GetAuthors_FullMethodName,
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(AuthorApiServer).GetAuthors(ctx, req.(*GetAuthorsRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _AuthorApi_SaveAuthor_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(AuthorCreateRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(AuthorApiServer).SaveAuthor(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: AuthorApi_SaveAuthor_FullMethodName,
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(AuthorApiServer).SaveAuthor(ctx, req.(*AuthorCreateRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _AuthorApi_UpdateAuthor_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(AuthorUpdateRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(AuthorApiServer).UpdateAuthor(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: AuthorApi_UpdateAuthor_FullMethodName,
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(AuthorApiServer).UpdateAuthor(ctx, req.(*AuthorUpdateRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _AuthorApi_GetById_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GetAuthorRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(AuthorApiServer).GetById(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: AuthorApi_GetById_FullMethodName,
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(AuthorApiServer).GetById(ctx, req.(*GetAuthorRequest))
	}
	return interceptor(ctx, in, info, handler)
}

// AuthorApi_ServiceDesc is the grpc.ServiceDesc for AuthorApi service.
// It's only intended for direct use with grpc.RegisterService,
// and not to be introspected or modified (even as a copy)
var AuthorApi_ServiceDesc = grpc.ServiceDesc{
	ServiceName: "posts.v1.AuthorApi",
	HandlerType: (*AuthorApiServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "GetAuthors",
			Handler:    _AuthorApi_GetAuthors_Handler,
		},
		{
			MethodName: "SaveAuthor",
			Handler:    _AuthorApi_SaveAuthor_Handler,
		},
		{
			MethodName: "UpdateAuthor",
			Handler:    _AuthorApi_UpdateAuthor_Handler,
		},
		{
			MethodName: "GetById",
			Handler:    _AuthorApi_GetById_Handler,
		},
	},
	Streams:  []grpc.StreamDesc{},
	Metadata: "post.proto",
}
